package io.codeforall.bootcamp;

public class MasterCoder {

    private String[] lectures = {
            "É pra simplificar",
            "Tudo tem uma ordem",
            "Tem de ter 5 cores",
            "Não se desinstala o VIM",
            "A manteiga de amendoim come-se pelo meio"
    };
    private static int coderCounter = 0;
    private int lecturesCounter;
    private final String name;
    private final int age;
    private String funFact;

    public MasterCoder(String name, int age, String funFact) {


        this.lecturesCounter = coderCounter;
        coderCounter++;
        coderCounterReset(coderCounter);
        this.name = name;
        this.age = age;
        this.funFact = funFact;

    }

    public MasterCoder() {
        final String undefined = "undefined";
        this.lecturesCounter = coderCounter;
        coderCounter++;
        coderCounterReset(coderCounter);
        this.name = undefined;
        this.age = -1;
        this.funFact = undefined;
    }

    private void coderCounterReset(int counter) {
        if(counter > 4) {
            coderCounter = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getFunFact() {
        return this.funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public void Greet() {
        System.out.println("Hey");
        System.out.print("Have you heard about... ");
        this.GiveLecture();
        System.out.println(this.Description());

    }

    private void GiveLecture() {
        System.out.println(lectures[lecturesCounter]);
    }

    private String Description() {
        String result = "Also, my name is " + this.name +
                ", I'm " + age +
                " years old and my fun fact is: " + this.funFact +
                ".";
        return result;
    }

}
