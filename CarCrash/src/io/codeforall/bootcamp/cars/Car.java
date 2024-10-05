package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;
import io.codeforall.bootcamp.Randomizer;

import java.util.Random;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;

    private String letter;
    private int velocity;
    private boolean hasCrashed;

    public Car(String letter) {
        this.letter = letter;
        this.velocity = 3;
        this.hasCrashed = false;
        // System.out.println(Randomizer.getRandomInt(Field.getWidth()));
        pos = new Position(Randomizer.getRandomInt(Field.getWidth()), Randomizer.getRandomInt(Field.getHeight()));
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public Position getPos() {
        return pos;
    }

    public void move(int frame){

        if (this.getHasCrashed()){
            return;
        }

        if (frame % this.velocity != 0) {
            return;
        }
        while(true) {
            switch (Direction.values()[Randomizer.getRandomInt(4)]) {
                case UP -> {
                    if (this.pos.getRow() - 1 > -1) {
                        this.pos.incRow(- 1);
                        return;
                    }
                }
                case DOWN -> {
                    if (this.pos.getRow() + 1 < Field.getHeight()) {
                        this.pos.incRow(1);
                        return;
                    }
                }
                case LEFT -> {
                    if (this.pos.getCol() - 1 > -1) {
                        this.pos.incCol(- 1);
                        return;
                    }
                }
                case RIGHT -> {
                    if (this.pos.getCol() + 1 < Field.getWidth()) {
                        this.pos.incCol(1);
                        return;
                    }
                }
            }
        }
    }

    public boolean getHasCrashed() {
        return this.hasCrashed;
    }

    public void crash() {
        this.hasCrashed = true;
    }

    public void repair() {
        this.hasCrashed = false;
    }

    @Override
    public String toString() {
        return (this.hasCrashed) ? "C" : letter;
    }

    public void getDebug() {
        System.out.printf("Car %s at x %d y %d%n",
                this.letter,
                this.pos.getCol(),
                this.pos.getRow());
    }
}
