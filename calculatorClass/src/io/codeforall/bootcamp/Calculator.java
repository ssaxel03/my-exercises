package io.codeforall.bootcamp;

public class Calculator {

     private static int numberOfCalculators = 0;
     private static enum colorsAvailable {
         blue,
         black,
         red,
         yellow,
         green,
         orange,
         white,

     }

     private String color = "black";
     private String brand = "Texas";

     private double counter = 0;

    public Calculator() {
        numberOfCalculators++;
    }

    public Calculator(String color, String brand) {
        this.color = color;
        this.brand = brand;
        numberOfCalculators++;
    }

    public void Add(double inc) {
        this.counter += inc;
        System.out.println("Counter: " + this.counter);
    }

    public void Add(long inc) {
        this.counter += inc;
        System.out.println("Counter: " + this.counter);
    }

    public void Subtract(double inc) {
        this.counter -= inc;
        System.out.println("Counter: " + this.counter);
    }

    public void Subtract(long inc) {
        this.counter -= inc;
        System.out.println("Counter: " + this.counter);
    }

    public double getCounter() {
        return this.counter;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if(isColorAvailable(color)) {
            this.color = color;
            return;
        }
        System.out.println("Cor inválida");
    }

    private boolean isColorAvailable(String color) {
        for (colorsAvailable c : colorsAvailable.values()) {
            if (c.name().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public String getBrand() {
        return brand;
    }
}
