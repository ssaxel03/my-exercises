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

        enemy.hit(this.bulletDamage);
        System.out.printf("%s has been hit (%d damage)%n", enemy.toString(), this.bulletDamage);
    }

}
