package io.codeforall.bootcamp;

public class SniperRifle {

    private final int bulletDamage;

    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public void shootEnemy(Enemy enemy) {

        if(Math.random() > 0.7) {
            System.out.println("Shot missed");
            return;
        }

        if(Math.random() < 0.1) {
            int damage = enemy.getHealthLeft();
            enemy.hit(damage, true);
            return;
        }

        enemy.hit(this.bulletDamage, false);
    }

}
