package com.company;


/**
 * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 * 10 3 1 2
 * 2 3 2 2
 * 5 6 7 1
 * 300 3 1 0
 * Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 * 3. Ваши методы должны бросить исключения в случаях:
 * Если размер матрицы, полученной из строки, не равен 4x4;
 * Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 * 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 * 5. * Написать собственные классы исключений для каждого из случаев
 */
public class Main {
    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String s1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n1 2";
        String s2 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 0";
        String s3 = "1e 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        try {
            //сценарий №1, положительный
            String[][] arrayStrings = resArray(s);
            double finResultOfArray = resultIntArray(arrayStrings);
            System.out.println(finResultOfArray);
        } catch (WrongRowsException | WrongColumnException | NotParseableValueException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        try {
            //сценарий №2, ошибка размерности двумерного массива (количество строк не равно 4)
            String[][] arrayStrings1 = resArray(s1);
            double finResultOfArray = resultIntArray(arrayStrings1);
            System.out.println(finResultOfArray);
        } catch (WrongRowsException | WrongColumnException | NotParseableValueException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            //сценарий №3, ошибка размерности двумерного массива (количество стобцов не равно 4)
            String[][] arrayStrings2 = resArray(s2);
            double finResultOfArray = resultIntArray(arrayStrings2);
            System.out.println(finResultOfArray);
        } catch (WrongRowsException | WrongColumnException | NotParseableValueException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            //сценарий №4, ошибка преобразования строки в число
            String[][] arrayStrings3 = resArray(s3);
            double finResultOfArray = resultIntArray(arrayStrings3);
            System.out.println(finResultOfArray);
        } catch (WrongRowsException | WrongColumnException | NotParseableValueException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

    }

    public static String[][] resArray(String s) throws WrongRowsException, WrongColumnException {
        String[][] resArray = new String[4][4];
        String[] split1 = s.split("\\n");
        if (split1.length != 4) {
            throw new WrongRowsException();
        }
        for (int i = 0; i < split1.length; i++) {
            String[] split2 = split1[i].split(" ");
            if (split2.length != 4) {
                throw new WrongColumnException();
            }
            for (int j = 0; j < split2.length; j++) {
                resArray[i][j] = split2[j];
            }
        }
        return resArray;
    }

    /**
     * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
     */
    public static double resultIntArray(String[][] a) throws NotParseableValueException {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                String cellValue = a[i][j];
                try {
                    result = result + Integer.parseInt(cellValue);
                } catch (NumberFormatException e) {
                    throw new NotParseableValueException(cellValue);
                }
            }

        }
        return result / 2;
    }

}
