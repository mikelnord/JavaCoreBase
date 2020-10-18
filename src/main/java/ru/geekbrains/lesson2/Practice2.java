package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Practice2 {

    public static void main(String[] args) {
//        Task 1
        System.out.println("Задача №1");
        int[] mas = {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(Arrays.toString(task1(mas)));
        System.out.println("____________________________________");
//        Task2
        System.out.println("Задача №2");
        int[] mas2 = new int[8];
        System.out.println(Arrays.toString(task2(mas2)));
        System.out.println("____________________________________");
//        Task3
        System.out.println("Задача №3");
        int[] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(task3(mas3)));
        System.out.println("____________________________________");
//        Task4
        System.out.println("Задача №4");
        int[][] mas4 = new int[8][8];
        task4(mas4);
        System.out.println("____________________________________");
//        Task5
        System.out.println("Задача №5");
        task5(mas3);
        System.out.println("____________________________________");

//        Task6
        System.out.println("Задача №6");
        int[] mas6 = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        if (task6(mas6)) {
            System.out.println("Нашли границу баланса");
        } else {
            System.out.println("Граница баланса не найдена");
        }
        System.out.println("____________________________________");

//        Task7
        System.out.println("Задача №7");
        int[] mas7 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(mas7));
        task7(mas7, 2);
        System.out.println(Arrays.toString(mas7));
        task7(mas7, -4);
        System.out.println(Arrays.toString(mas7));

    }


    public static int[] task1(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (mas[i] > 0) ? 0 : 1;
        }
        return mas;
    }

    public static int[] task2(int[] mas) {
        if (mas.length == 8) {
            mas[0] = 0;
            mas[1] = 3;
            mas[2] = 6;
            mas[3] = 9;
            mas[4] = 12;
            mas[5] = 15;
            mas[6] = 18;
            mas[7] = 21;
        }
        return mas;
    }

    public static int[] task3(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] = mas[i] * 2;
            }
        }
        return mas;
    }

    public static void task4(int[][] mas) {
        for (int j = 0; j < mas.length; j++)
            for (int i = 0; i < mas[j].length; i++) {
                mas[j][i] = 0; //(int) (10*Math.random());
            }
        System.out.println("Массив до изменения");
        for (int[] m : mas) {
            System.out.println(Arrays.toString(m));
        }
        for (int j = 0; j < mas.length; j++)
            for (int i = 0; i < mas[j].length; i++) {
                if (i == j || i == mas[j].length - 1 - j)
                    mas[j][i] = 1;
            }
        System.out.println("Массив с заполненными диагональными элементами");
        System.out.println("------------------------------");
        for (int[] m : mas) {
            System.out.println(Arrays.toString(m));
        }

    }

    public static void task5(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max) max = mas[i];
            if (mas[i] < min) min = mas[i];
        }
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }

    public static int checkSumm(int[] mas, int nach, int kon) {
        int result = 0;
        for (int i = nach; i <= kon; i++) {
            result += mas[i];
        }
        return result;
    }

    public static boolean task6(int[] mas) {
        for (int i = 1; i < mas.length - 2; i++)
            if (checkSumm(mas, 0, i) == checkSumm(mas, i + 1, mas.length - 1)) return true;
        return false;
    }

    public static void stepRight(int[] mas) {
        int temp = mas[mas.length - 1];
        for (int i = mas.length - 1; i > 0; i--) {
            mas[i] = mas[i - 1];
        }
        mas[0] = temp;
    }

    public static void stepLeft(int[] mas) {
        int temp = mas[0];
        for (int i = 0; i < mas.length - 1; i++) {
            mas[i] = mas[i + 1];
        }
        mas[mas.length - 1] = temp;
    }

    public static void task7(int[] mas, int n) {
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                stepRight(mas);
            }

        } else if (n < 0) {
            for (int i = 1; i <= (Math.abs(n)); i++) {
                stepLeft(mas);
            }
        }
    }

}
