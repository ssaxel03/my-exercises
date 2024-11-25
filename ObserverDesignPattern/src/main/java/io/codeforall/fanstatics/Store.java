package io.codeforall.fanstatics;

import io.codeforall.fanstatics.observer.EventType;

public class Store {

    private String name;
    private EventManager eventManager;

    public Store (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void buyAllProducts() {
        System.out.printf("%s: Someone just bought all of our products!\n", this.name);
        eventManager.notify(
                EventType.OUT_OF_STOCK,
                String.format("%s: %s",
                        this.name,
                        EventType.OUT_OF_STOCK.getDefaultMessage())
        );
    }

    public void goOnSale() {
        System.out.printf("%s: Let's go on sale!\n", this.name);
        eventManager.notify(
                EventType.SALE,
                String.format("%s: %s",
                        this.name,
                        EventType.SALE.getDefaultMessage())
        );
    }

    public void replenishCookieMakerStock() {
        System.out.printf("%s: We finally have more Cookie Makers!\n", this.name);
        eventManager.notify(
                EventType.COOKIE_MAKER_REPLENISH,
                String.format("%s: %s",
                        this.name,
                        EventType.COOKIE_MAKER_REPLENISH.getDefaultMessage())
        );
    }

    public EventManager getEventManager() {
        return this.eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }
}
