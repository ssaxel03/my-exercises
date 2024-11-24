package io.codeforall.fanstatics.observer;

public interface Publisher {
    public void subscribe(EventType event, Subscriber listener);
    public void unsubscribe(EventType event, Subscriber listener);
    public void notify(EventType event);
    public void notify(EventType event, String customMessage);
}
