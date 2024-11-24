package io.codeforall.fanstatics.observer;

public enum EventType {
    OUT_OF_STOCK("The store is out of stock!"),
    SALE("The store has new products on sale!"),
    COOKIE_MAKER_REPLENISH("The store has replenished its stock of cookie makers, thanks to Hügens!");

    private String defaultMessage;

    EventType(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return this.defaultMessage;
    }
}
