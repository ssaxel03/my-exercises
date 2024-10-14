package io.codeforall.fanstatics;

public enum Importance {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int importanceValue;

    Importance(int importanceValue) {
        this.importanceValue = importanceValue;
    }

    public int getImportanceValue() {
        return importanceValue;
    }
}
