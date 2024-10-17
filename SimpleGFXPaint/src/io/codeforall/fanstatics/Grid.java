package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class Grid {

    public final int PADDING = 10;
    private final java.awt.Rectangle bounds;

    private final int size;
    private final int cellSize;

    private Cell[][] cells;
    private Rectangle cursor;
    private boolean hasAlreadyPainted;

    public Grid(int size, int cellSize) {

        this.size = size;
        this.cellSize = cellSize;
        this.bounds = new java.awt.Rectangle(this.PADDING, this.PADDING, size * cellSize, size * cellSize);

    }

    public void init() {

        this.cells = new Cell[size][size];
        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {

                this.cells[x][y] = new Cell(
                        this.PADDING + this.coordinatesToPixels(x),
                        this.PADDING + this.coordinatesToPixels(y));
                this.cells[x][y].draw();
            }
        }

        this.cursor = new Rectangle(
                this.PADDING + this.coordinatesToPixels(0),
                this.PADDING + this.coordinatesToPixels(0),
                this.cellSize,
                this.cellSize);
        System.out.println(pixelsToCoordinates(this.cursor.getX()));
        this.cursor.setColor(Color.ORANGE);
        this.cursor.fill();

        this.hasAlreadyPainted = false;

    }

    public int coordinatesToPixels(int coordinate) {
        return coordinate * this.cellSize;
    }

    public int pixelsToCoordinates(int pixel) {
        return pixel / this.cellSize;
    }

    public void paintOrErase() {

        if(hasAlreadyPainted) {
            return;
        }

        int cursorCoordinateX = pixelsToCoordinates(this.cursor.getX() - this.PADDING);
        System.out.println(cursorCoordinateX);
        int cursorCoordinateY = pixelsToCoordinates(this.cursor.getY() - this.PADDING);

        if(cells[cursorCoordinateX]
                [cursorCoordinateY].isPainted()) {
            this.erase(cursorCoordinateX, cursorCoordinateY);
            cells[cursorCoordinateX][cursorCoordinateY].setPainted();
            this.hasAlreadyPainted = true;
        } else {
            this.paint(cursorCoordinateX, cursorCoordinateY);
            cells[cursorCoordinateX][cursorCoordinateY].setPainted();
            this.hasAlreadyPainted = true;
        }

    }

    private void paintOrErase(int coordinateX, int coordinateY, boolean isPainted) {

        if(isPainted) {
            this.paint(coordinateX, coordinateY);
        } else {
           this.erase(coordinateX, coordinateY);
        }

        cells[coordinateX][coordinateY].setPainted(isPainted);
        this.hasAlreadyPainted = false;

    }

    private void paint(int coordinateX, int coordinateY) {
        this.cells[coordinateX][coordinateY].setColor(Color.BLACK);
        this.cells[coordinateX][coordinateY].fill();
    }

    private void erase(int coordinateX, int coordinateY) {
        this.cells[coordinateX][coordinateY].delete();
        this.cells[coordinateX][coordinateY].draw();
    }

    public void clear() {

        for(int x = 0; x < this.size; x++) {
            for(int y = 0; y < this.size; y++) {
                this.erase(x, y);
                this.cells[x][y].isPainted = false;
            }
        }

    }
    public void save() {
        try{
            FileManager.saveCanvas(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void load() {
        try {
            char[] data = FileManager.loadCanvas().toCharArray();

            System.out.println("TESTING");

            int currentChar = 0;

            for(int y = 0; y < size; y++) {
                for(int x = 0; x < size; x++) {
                    this.paintOrErase(x, y, (data[currentChar] + "").equals("1"));
                    currentChar++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void moveCursor(int coordinateTranslateX, int coordinateTranslateY) {

        if(!this.bounds.contains(new java.awt.Rectangle(
                this.cursor.getX() + this.coordinatesToPixels(coordinateTranslateX),
                this.cursor.getY() + this.coordinatesToPixels(coordinateTranslateY),
                this.cellSize,
                this.cellSize))) {
            this.cursor.fill();
            return;
        }

        this.cursor.translate(
                this.coordinatesToPixels(coordinateTranslateX),
                this.coordinatesToPixels(coordinateTranslateY));

        if(Vectors.getVectorLength(coordinateTranslateX, coordinateTranslateY) > 0) {
            this.hasAlreadyPainted = false;
        }
        this.cursor.fill();
    }

    public String getSaveFile() {

        String result = "";

        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                result = result.concat(cells[x][y].isPainted ? "1" : "0");
            }
        }

        return result;
    }

    public class Cell extends Rectangle {

        private boolean isPainted;

        public Cell(int posX, int posY) {
            super(posX, posY, cellSize, cellSize);
            this.isPainted = false;
        }

        public boolean isPainted() {
            return isPainted;
        }

        public void setPainted() {
            this.isPainted = !this.isPainted;
        }
        public void setPainted(boolean isPainted) {
            this.isPainted = isPainted;
        }

    }

}
