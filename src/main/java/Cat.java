public class Cat extends Animal {
    static private final int SWIMLENGTH = 0;
    static private final int RUNLENGTH = 200;
    private static int countCat = 0;
    private final String name;

    public Cat(String name) {
        this.name = name;
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(int length) {
        if (length <= RUNLENGTH) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " столько не пробежит!");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать. Бульк!");
    }
}
