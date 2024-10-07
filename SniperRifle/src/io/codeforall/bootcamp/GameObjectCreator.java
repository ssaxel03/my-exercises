package io.codeforall.bootcamp;

public class GameObjectCreator {

    public static GameObject getNewGameObject() {

        if(Math.random() > 0.8) {
            return new Tree();
        }

        if(Math.random() >= 0.5) {
            return new ArmouredEnemy();
        }

        return new SoldierEnemy();

    }

}
