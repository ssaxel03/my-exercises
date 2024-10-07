package io.codeforall.bootcamp.gameobject;

public interface Destroyable {

    void hit(int damage);

    boolean isDestroyed();

}
