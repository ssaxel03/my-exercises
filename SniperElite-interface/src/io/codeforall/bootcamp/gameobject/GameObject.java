package io.codeforall.bootcamp.gameobject;

/**
 * A Generic game object meant for subclassing
 */
public abstract class GameObject {

    public abstract void burn();

    /**
     * Provides a short object description
     * @return Message describing the object
     */
    public abstract String getMessage();

}
