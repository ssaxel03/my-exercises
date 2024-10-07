package io.codeforall.bootcamp;

public class Game {

    private final int GAME_OBJECTS_AMOUNT = 10;
    private final int BULLET_DAMAGE = 70;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;

    public Game() {
        this.gameObjects = new GameObject[GAME_OBJECTS_AMOUNT];
        for(int i = 0; i < this.gameObjects.length; i++) {
            gameObjects[i] = GameObjectCreator.getNewGameObject();
        }

        this.sniperRifle = new SniperRifle(BULLET_DAMAGE);

        this.shotsFired = 0;
    }

    public void start() {

        for(GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if(gameObject.getClass() == Tree.class) {
                continue;
            }

            while(!((Enemy) gameObject).isDead()) {
                this.sniperRifle.shootEnemy((Enemy) gameObject);
                this.shotsFired++;
            }

            System.out.printf("%s killed%n", gameObject.toString());

        }

        System.out.printf("Game finished with %d shots fired%n", this.shotsFired);

    }
}
