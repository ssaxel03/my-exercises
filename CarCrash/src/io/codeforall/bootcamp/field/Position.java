package io.codeforall.bootcamp.field;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void incCol(int incAmount) {
        this.col += incAmount;
    }

    public void incRow(int incAmount) {
        this.row += incAmount;
    }

    public boolean equals(Position position) {
        return this.col == position.getCol() && this.row == position.getRow();
    }

    public int getDIstance(Position position) {
        return Math.abs(this.getCol() - position.getCol()) + Math.abs(this.getRow() - position.getRow());
    }
}
