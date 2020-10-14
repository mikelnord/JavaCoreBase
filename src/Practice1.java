public class Practice1 {
    public static void main(String[] args) {
        byte b = 120;
        short sh = 3000;
        int i = 100;
        long l = 1000000L;
        float f = 3.14f;
        double d = 3.14;
        char c='c';
        boolean bool=true;
        System.out.println(vich(5,10,15,3.14));
    }
    public static double vich(int a, int b, int c, double d){
        if(d!=0){
            return a * (b + (c / d));
        }
        return 0;
    }
}
