public class Practice1 {
    public static void main(String[] args) {
        byte b = 120;
        short sh = 3000;
        int i = 100;
        long l = 1000000L;
        float f = 3.14f;
        double d = 3.14;
        char c = 'c';
        boolean bool = true;

    }

    public static double vich(int a, int b, int c, double d) {
        if (d != 0) {
            return a * (b + (c / d));
        }
        return 0;
    }

    public static boolean checkSum(int a, int b) {
        int d = a + b;
        return d > 10 && d <= 20;
    }

    public static void printInt(int a) {
        if (a < 0) System.out.println("Число отрицательное");
        else System.out.println("Число положительное");
    }

    public static boolean isNegativ(int a) {
        return a < 0;
    }

    public static void privet(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void isVis(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            System.out.println(year + " - високосный");
        } else {
            System.out.println(year + " - не високосный");
        }
    }
}
