package io.codeforall.bootcamp;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Game {

    private final int GAME_OBJECTS_AMOUNT = 10;
    private int BULLET_DAMAGE = 70;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;

    public Game() {

        if (GAME_OBJECTS_AMOUNT <= 0) {
            System.out.println("TRATEM-SE (GAME_OBJECTS_AMOUNT_NEGATIVE_SIZE_EXCEPTION");
            return;
        }

        gameObjects = createObjects(GAME_OBJECTS_AMOUNT);

        this.sniperRifle = new SniperRifle(BULLET_DAMAGE);

        this.shotsFired = 0;
    }

    public void start() {

        if(BULLET_DAMAGE <= 0) {
            System.out.println("TRATEM-SE (BULLET_DAMAGE_NEGATIVE_OR_ZERO_VALUE_EXCEPTION)");
            return;
        }

        if(gameObjects == null) {
            return;
        }

        for(GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if(gameObject.getClass() == Tree.class) {
                continue;
            }

            while(!((Enemy) gameObject).isDead()) {
                this.sniperRifle.shootEnemy((Enemy) gameObject);
                this.shotsFired++;
            }

            System.out.printf("%s died%n", gameObject.toString());

        }

        System.out.printf("Game finished with %d shots fired%n", this.shotsFired);

    }

    private GameObject[] createObjects(int objectsAmount) {

        GameObject[] arr = new GameObject[GAME_OBJECTS_AMOUNT];

        for(int i = 0; i < arr.length; i++) {

            if (Math.random() > 0.8) {
                arr[i] = new Tree();
            }

            if (Math.random() >= 0.5) {
                arr[i] = new ArmouredEnemy();
            }

            arr[i] = new SoldierEnemy();
        }

        return arr;
    }
}
