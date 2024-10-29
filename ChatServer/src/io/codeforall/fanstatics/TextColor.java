package io.codeforall.fanstatics;

public enum TextColor {

    ANSI_RESET("\u001B[0m", "reset"),
    ANSI_RED("\u001B[31m", "red"),
    ANSI_GREEN("\u001B[32m", "green"),
    ANSI_YELLOW("\u001B[33m", "yellow"),
    ANSI_BLUE("\u001B[34m", "blue");

    private String code;
    private String name;

    TextColor(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getColor() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
