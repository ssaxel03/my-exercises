package io.codeforall.bootcamp.test;

import io.codeforall.bootcamp.gfx.lanterna.LanternaGrid;
import io.codeforall.bootcamp.grid.*;
import io.codeforall.bootcamp.grid.position.GridPosition;

public class LanternaGridTest {


    private static GridType gridType = GridType.LANTERNA;

    private final static int COL_NUM = 80;
    private final static int ROW_NUM = 25;
    private final static int CYCLES = 3;

    private final static int TEST_DELAY = 500;
    private final static int TEST_STEP = 800;

    public static void main(String[] args) {

        LanternaGrid grid = (LanternaGrid) GridFactory.makeGrid(gridType, COL_NUM, ROW_NUM);

        assertCondition("Grid appearance test",stepOne(grid));
        assertCondition("Grid's position show/hide test",stepTwo(grid));
        assertCondition("Grid's position color && movement test",stepThree(grid));
        assertCondition("Grid boundaries and the grid's position color && movement test",finalStep(grid, CYCLES));

    }

    /**
     * Tests the grid positions color
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static boolean stepOne(LanternaGrid grid){

        grid.init();

        if (grid.getCols() != COL_NUM || grid.getRows() != ROW_NUM)  {
            return false;
        }

        return true;

    }

    /**
     * Tests the grid positions appearance methods
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static boolean stepTwo(Grid grid){

        try {

            GridPosition pos = grid.makeGridPosition(0, 0);
            pos.show();

            if (pos.getCol() != 0 || pos.getRow() != 0) {
                return false;
            }

            Thread.sleep(TEST_DELAY);

            pos.hide();


        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        return true;

    }

    /**
     * Tests the grid's position color and movement
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static boolean stepThree(Grid grid){


        try {

            GridPosition pos = grid.makeGridPosition(0, 0);
            pos.setColor(GridColor.BLUE);

            if (pos.getColor() != GridColor.BLUE) {
                return false;
            }

            Thread.sleep(TEST_DELAY);

            pos.moveInDirection(GridDirection.RIGHT,1);
            pos.setColor(GridColor.RED);

            if (pos.getCol() != 1) {
                return false;
            }

            if (pos.getColor() != GridColor.RED) {
                return false;
            }

            Thread.sleep(TEST_DELAY);

            pos.hide();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;

    }

    /**
     * Performs a basic grid boundaries, grid position color && movement test
     * @param grid graphics library associated grid object
     * @param cycles number of laps the grid's position will make round the grid
     * @return test result flag
     */
    private static boolean finalStep(Grid grid, int cycles) {

        GridPosition pos = grid.makeGridPosition(0, 0);
        pos.setColor(GridColor.BLUE);

        try {

            while (cycles > 0) {

                pos.setColor(cycles % 2 == 0? GridColor.BLUE : GridColor.RED);
                cycles--;

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.DOWN, TEST_STEP);

                if (pos.getRow() >= ROW_NUM) {
                    return false;
                }

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.RIGHT, TEST_STEP);

                if (pos.getCol() >= COL_NUM) {
                    return false;
                }

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.UP, TEST_STEP);

                if (pos.getRow() < 0) {
                    return false;
                }

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.LEFT, TEST_STEP);

                if (pos.getCol() < 0) {
                    return false;
                }

                Thread.sleep(TEST_DELAY);
                pos.hide();

                Thread.sleep(TEST_DELAY);
                pos.show();

            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return true;

    }

    private static void assertCondition(String test, boolean result){

        System.out.println(test + ": " + (result ? "OK" : "FAIL"));

    }

}

