package io.codeforall.fanstatics;

import io.codeforall.fanstatics.observer.EventType;
import io.codeforall.fanstatics.observer.Publisher;
import io.codeforall.fanstatics.observer.Subscriber;

import java.util.HashMap;
import java.util.LinkedList;

public class EventManager implements Publisher {

    HashMap<EventType, LinkedList<Subscriber>> listeners;

    public EventManager() {

        listeners = new HashMap<>();

        for (EventType event : EventType.values()) {
            listeners.put(event, new LinkedList<>());
        }
    }

    @Override
    public void subscribe(EventType event, Subscriber listener) {

        listeners.get(event).add(listener);
    }

    @Override
    public void unsubscribe(EventType event, Subscriber listener) {

        listeners.get(event).remove(listener);
    }

    @Override
    public void notify(EventType event) {

        for (Subscriber listener : listeners.get(event)) {
            // send email
            // send sms
            // send simple mobile notification
            listener.update(event.getDefaultMessage());
        }
    }

    @Override
    public void notify(EventType event, String customMessage) {

        for (Subscriber listener : listeners.get(event)) {
            listener.update(customMessage);
        }
    }
}
