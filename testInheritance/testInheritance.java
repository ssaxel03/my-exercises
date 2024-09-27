public class testInheritance {
    public static void main(String[] args) {

        Person axel = new Person("humano", 21, "Axel", "Totó", "Gaia");
        Chicken chicken = new Chicken("galinha", 3, "co co ro co co");

        axel.Greet();
        chicken.Cluck();

    }
}