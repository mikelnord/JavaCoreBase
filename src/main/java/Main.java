public class Main {
    public static void main(String[] args) {
        Cat vaska = new Cat("Васька");
        Cat murz = new Cat("Мурзик");
        vaska.run(100);
        murz.run(150);
        vaska.run(210);
        murz.swim(50);
        System.out.println("Всего котов " + Cat.getCountCat());

        Dog barni = new Dog("Barni");
        barni.run(250);
        barni.swim(8);
        System.out.println("Всего собак " + Dog.getCountDog());

    }
}
