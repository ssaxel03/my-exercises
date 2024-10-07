package io.codeforall.bootcamp.gameobject;

import io.codeforall.bootcamp.gameobject.enemy.ArmouredEnemy;
import io.codeforall.bootcamp.gameobject.enemy.Enemy;
import io.codeforall.bootcamp.gameobject.enemy.SoldierEnemy;

public class GameObjectFactory {

    public static int ENEMY_HEALTH = 3;
    public static int ARMOUR = 3;

    public static GameObject createDestroyable() {

        if(Math.random() < 0.2){
            return new Barrel(BarrelType.values()[(int) (Math.random() * 3)]);
        }

        return Math.random() > 0.5 ? new SoldierEnemy(ENEMY_HEALTH) : new ArmouredEnemy(ENEMY_HEALTH, ARMOUR);

    }

}
