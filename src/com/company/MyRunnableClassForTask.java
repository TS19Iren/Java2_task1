package com.company;

public class MyRunnableClassForTask implements Runnable {

     private float [] arr;


    public MyRunnableClassForTask(float[] arr1) {
        this.arr = arr1;
         }

    @Override
    public void run() {
    Main.method1(arr);
    }
}
