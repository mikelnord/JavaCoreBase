public class Dog extends Animal {
    static private final int SWIMLENGTH = 10;
    static private final int RUNLENGTH = 500;
    private static int countDog = 0;
    private final String name;

    public Dog(String name) {
        this.name = name;
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(int length) {
        if (length <= RUNLENGTH) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println("Собаки столько не пробегут!");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= SWIMLENGTH) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " столько не проплывет!");
        }
    }
}
