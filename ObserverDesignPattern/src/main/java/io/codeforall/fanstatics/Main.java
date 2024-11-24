package io.codeforall.fanstatics;

import io.codeforall.fanstatics.observer.EventType;

public class Main {

    public static void main(String[] args) {
        // create both the event manager and the store and associate them
        EventManager eventManager = new EventManager();
        Store walmart = new Store("Walmart");
        walmart.setEventManager(eventManager);
        // create the clients
        Client joao = new Client("João");
        Client gabriela = new Client("Gabriela");
        Client lucas = new Client("Lucas");
        // subscribe joao to some events
        eventManager.subscribe(EventType.OUT_OF_STOCK, joao);
        eventManager.subscribe(EventType.SALE, joao);
        // subscribe gabriela to some events
        eventManager.subscribe(EventType.SALE, gabriela);
        eventManager.subscribe(EventType.COOKIE_MAKER_REPLENISH, gabriela);
        // subscribe lucas to some events
        eventManager.subscribe(EventType.OUT_OF_STOCK, lucas);
        eventManager.subscribe(EventType.SALE, lucas);
        eventManager.subscribe(EventType.COOKIE_MAKER_REPLENISH, lucas);

        // now let's see what happens

        // walmart goes on sale
        walmart.goOnSale();
        System.out.println();
        // someone buys all of walmart's stock
        walmart.buyAllProducts();
        System.out.println();
        // walmart replenishes its cookie maker stock
        walmart.replenishCookieMakerStock();
    }
}