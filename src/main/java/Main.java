public class Main {
    public static void main(String[] args) {
        Cat[] packCats = new Cat[]{new Cat("Барсик", 10), new Cat("Мурзик", 20), new Cat("Ластик", 15)};
        Plate plate = new Plate(25);
        for (Cat cat : packCats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println("Кот остался голодный, непорядок.");
        System.out.println("Доложим еды и покормим его одного.");
        plate.addFood(20);
        packCats[1].eat(plate);
        for (Cat cat : packCats) {
            System.out.println(cat);
        }
    }
}
