public class Chicken extends LivingBeing{

    private String sound;

    public Chicken(String species, int age, String sound) {
        this.species = species;
        this.age = age;
        this.sound = sound;
    }

    public void Cluck() {
        System.out.println(sound);
    }


}
