package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1) Создают одномерный длинный массив, например:
 * <p>
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * <p>
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * <p>
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 * <p>
 * Пример обратной склейки:
 * <p>
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 * <p>
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение,
 * откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * <p>
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * <p>
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        // method1(arr);
        method2(arr);

    }

     static void method1(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0, len = arr.length; i < len; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("Время подсчета составило: " + (b - a));
    }

    static void method2(float[] arr) throws InterruptedException {

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long time = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("    Время деления массива на 2: " + (System.currentTimeMillis() - time));
        Thread t1 = new Thread(new MyRunnableClassForTask(a1));
        Thread t2 = new Thread(new MyRunnableClassForTask(a2));
        long time1 = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("    Время подсчета: " + (System.currentTimeMillis() - time1));
        //с помощью join ожидается выполнение самого долгого потока, ввиду того что method1 не synchronized. потоки работают паралелльно
        long time2 = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("    Время склейки: "+ (System.currentTimeMillis()-time2));
        System.out.println("Время всей операции: " + (System.currentTimeMillis()-time));

    }

}
