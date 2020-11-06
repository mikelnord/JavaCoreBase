public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public String isSatiety() {
        return satiety ? "Сытый" : "Голодный";
    }

    @Override
    public String toString() {
        return "Кот { Имя = " + name + " -- " + isSatiety() + " }";
    }
}
