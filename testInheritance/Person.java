public class Person extends LivingBeing {

    private String name;
    private String job;
    private String city;

    public Person(String species, int age, String name, String job, String city) {
        this.species = species;
        this.age = age;
        this.name = name;
        this.job = job;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void Greet() {
        System.out.println("Espécie: " + this.species);
        System.out.println("Idade: " + this.age);
        System.out.println("Nome: " + this.name);
        System.out.println("Trabalho: " + this.job);
        System.out.println("Cidade: " + this.city);
    }
}
