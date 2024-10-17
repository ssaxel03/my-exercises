package io.codeforall.fanstatics;

public class ProgramManager {

    private Grid grid;
    private InputManager inputManager;

    public ProgramManager(int gridSize, int gridCellSize) {
        grid = new Grid(gridSize, gridCellSize);
        inputManager = new InputManager();
    }

    public void init() {
        grid.init();
        inputManager.init();
    }

    public void run() throws InterruptedException {

        while(true) {

            if(inputManager.getSpace()) {grid.paintOrErase();}

            if(inputManager.getClear()) {grid.clear();}

            if(inputManager.getSave()) {grid.save();}

            if(inputManager.getLoad()) {grid.load();}

            this.moveCursor();

            Thread.sleep(100);

        }

    }

    public void moveCursor() {

        int directionX = inputManager.getMoveRight() - inputManager.getMoveLeft();
        int directionY = inputManager.getMoveDown() - inputManager.getMoveUp();

        grid.moveCursor(directionX, directionY);

    }

}
