import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice4 {

    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static char[][] map;
    public static char[] mas;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void initMap() {
        mas = new char[DOTS_TO_WIN];
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static int[] checkHumanWinVert() {
        char[] masVert = new char[SIZE];
        char[] masDiag1 = new char[SIZE];
        char[] masDiag2 = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                masVert[j] = map[j][i];
                if (j == i) masDiag1[i] = map[j][i];
                if (j == SIZE - 1 - i) masDiag2[i] = map[i][j];
            }
            int[] mas = summSymb(masVert);
            if ((mas[0] >= 2) && (mas[1] != (-1))) {
                mas[0] = i;
                return mas;
            }
        }
        int[] mas = summSymb(masDiag1);
        if ((mas[0] >= 2) && (mas[1] != (-1))) {
            mas[0] = mas[1];
            return mas;
        }
        mas = summSymb(masDiag2);
        if ((mas[0] >= 2) && (mas[1] != (-1))) {
            mas[0] = mas[1];
            return mas;
        }

        return new int[]{-1, -1};
    }

    public static int[] checkHumanWinHor() {
        for (int i = 0; i < SIZE; i++) {
            int[] mas = summSymb(map[i]);
            if ((mas[0] >= 2) && (mas[1] != (-1))) {
                mas[0] = i;
                return mas;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] summSymb(char[] mas) {
        int sum = 0;
        int koor = -1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == DOT_X) {
                sum++;
                if (((i + 1) < mas.length) && (mas[i + 1] == DOT_EMPTY) && (koor == -1)) {
                    koor = i + 1;
                }
                if (((i - 1) >= 0) && (mas[i - 1] == DOT_EMPTY) && (koor == -1)) {
                    koor = i - 1;
                }

            }
        }
        return new int[]{sum, koor};
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellNoValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {
            int[] mas = checkHumanWinHor();
            if (mas[0] != (-1)) {
                y = mas[0];
                x = mas[1];
            } else {
                mas = checkHumanWinVert();
                if (mas[0] != (-1)) {
                    y = mas[1];
                    x = mas[0];
                } else {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                }
            }
        } while (isCellNoValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean checkWin(char symb) {
        Arrays.fill(mas, symb);
        // проверяем горизонтальные строки
        for (int i = 0; i < SIZE; i++)
            if (sravMas(mas, map[i]))
                return true;
        // проверяем вертикальные строки
        char[] masVert = new char[SIZE];
        char[] masDiag1 = new char[SIZE];
        char[] masDiag2 = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                masVert[j] = map[j][i];
                if (j == i) masDiag1[i] = map[j][i];
                if (j == SIZE - 1 - i) masDiag2[i] = map[i][j];
            }
            if (sravMas(mas, masVert))
                return true;
        }
        //проверка диагоналей
        if (sravMas(mas, masDiag1))
            return true;
        return sravMas(mas, masDiag2);
    }

    public static boolean sravMas(char[] mas, char[] masMap) {
        char[] mas2 = new char[DOTS_TO_WIN];
        System.arraycopy(masMap, 0, mas2, 0, DOTS_TO_WIN);
        if (Arrays.equals(mas, mas2))
            return true;
        System.arraycopy(masMap, 1, mas2, 0, DOTS_TO_WIN);
        return Arrays.equals(mas, mas2);

    }

    public static boolean isCellNoValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
        return map[y][x] != DOT_EMPTY;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }
}