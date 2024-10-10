package io.codeforall.bootcamp.test;

import io.codeforall.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.bootcamp.grid.GridColor;
import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.GridFactory;
import io.codeforall.bootcamp.grid.GridType;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.util.List;

/**
 * Unit tests for SimpleGfxGrid
 */
public class SimpleGfxGridTest {

    private final static int COL_NUM = 80;
    private final static int ROW_NUM = 25;
    private final static int CYCLES = 3;
    private final static int TEST_DELAY = 500;
    private final static int TEST_STEP = 800;
    private static GridType gridType = GridType.SIMPLE_GFX;

    public static void main(String[] args) {

        SimpleGfxGrid grid = (SimpleGfxGrid) GridFactory.makeGrid(gridType, COL_NUM, ROW_NUM);

        assertCondition("Grid appearance test", stepOne(grid));
        assertCondition("Grid's position show/hide test", stepTwo(grid));
        assertCondition("Grid's position color && movement test", stepThree(grid));
        assertCondition("Grid boundaries and the grid's position color && movement test", finalStep(grid, CYCLES));

    }

    /**
     * Tests the grid positions color
     *
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static TestResult stepOne(SimpleGfxGrid grid) {

        grid.init();

        List<Shape> shapes = Canvas.getInstance().getShapes();
        if (shapes.size() != 1) {
            return new TestResult(false, "canvas should contain only the grid shape");
        }

        Shape gridBorder = shapes.toArray(new Shape[shapes.size()])[0];
        if (!(gridBorder instanceof Rectangle)) {
            return new TestResult(false, "grid shape should be of type rectangle");
        }

        if (((Rectangle) gridBorder).isFilled()) {
            return new TestResult(false, "grid should not be filled");
        }

        if (grid.getWidth() != COL_NUM * grid.getCellSize() || grid.getHeight() != ROW_NUM * grid.getCellSize()) {
            return new TestResult(false, "incorrect grid dimensions");
        }

        if (grid.getX() != SimpleGfxGrid.PADDING || grid.getY() != SimpleGfxGrid.PADDING) {
            return new TestResult(false, "incorrect grid position not accounting with necessary canvas padding");
        }

        return new TestResult(true, null);

    }

    /**
     * Tests the grid positions appearance methods
     *
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static TestResult stepTwo(SimpleGfxGrid grid) {

        try {

            GridPosition pos = grid.makeGridPosition(0, 0);

            if (pos.getCol() != 0 || pos.getRow() != 0) {
                return new TestResult(false, "position coordinates are wrong");
            }

            List<Shape> shapes = Canvas.getInstance().getShapes();
            if (shapes.size() != 2) {
                return new TestResult(false, "shape not found on canvas");
            }

            Shape gridPos = shapes.toArray(new Shape[shapes.size()])[1];
            if (!(gridPos instanceof Rectangle)) {
                return new TestResult(false, "shape should be a rectangle");
            }

            pos.show();

            if (!((Rectangle) gridPos).isFilled()) {
                return new TestResult(false, "shape not filled after show method is called");
            }


            if (gridPos.getWidth() != grid.getCellSize() || gridPos.getHeight() != grid.getCellSize()) {
                return new TestResult(false, "shape has incorrect size");
            }

            if (gridPos.getX() != SimpleGfxGrid.PADDING || gridPos.getY() != SimpleGfxGrid.PADDING) {
                return new TestResult(false, "shape is not properly placed on the grid");
            }


            GridPosition pos2 = grid.makeGridPosition(13, 18);

            if (pos2.getCol() != 13 || pos2.getRow() != 18) {
                return new TestResult(false, "second position coordinates are wrong");
            }

            shapes = Canvas.getInstance().getShapes();

            Shape gridPos2 = shapes.toArray(new Shape[shapes.size()])[2];

            if (gridPos2.getX() != pos2.getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING ||
                    gridPos2.getY() != pos2.getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING) {
                return new TestResult(false, "SECOND shape is not properly placed on the grid");
            }

            pos2.hide();

            Thread.sleep(TEST_DELAY);

            pos.hide();

            if (shapes.size() != 1) {
                return new TestResult(false, "shape found on canvas before after hide method is called");
            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        return new TestResult(true, null);

    }

    /**
     * Tests the grid's position color and movement
     *
     * @param grid graphics library associated grid object
     * @return test result flag
     */
    private static TestResult stepThree(SimpleGfxGrid grid) {

        try {

            GridPosition pos = grid.makeGridPosition(0, 0);
            List<Shape> shapes = Canvas.getInstance().getShapes();
            Shape gridPos = shapes.toArray(new Shape[shapes.size()])[1];

            pos.setColor(GridColor.BLUE);
            if (pos.getColor() != GridColor.BLUE) {
                return new TestResult(false, "position has the wrong color, should be blue");
            }

            if (((Rectangle) gridPos).getColor() != Color.BLUE) {
                return new TestResult(false, "shape has the wrong color, should be blue");
            }

            Thread.sleep(TEST_DELAY);

            pos.moveInDirection(GridDirection.RIGHT, 1);

            if (pos.getCol() != 1 && pos.getRow() != 0) {
                return new TestResult(false, "position coordinates are wrong after moving right");
            }

            pos.setColor(GridColor.RED);

            if (pos.getColor() != GridColor.RED) {
                return new TestResult(false, "position has the wrong color, should be red");
            }

            if (((Rectangle) gridPos).getColor() != Color.RED) {
                return new TestResult(false, "shape has the wrong color, should be red");
            }

            if (gridPos.getWidth() != grid.getCellSize() || gridPos.getHeight() != grid.getCellSize()) {
                return new TestResult(false, "shape has the wrong size");
            }

            if (gridPos.getX() != SimpleGfxGrid.PADDING + grid.getCellSize() || gridPos.getY() != SimpleGfxGrid.PADDING) {
                return new TestResult(false, "shape is not properly placed on the grid");
            }

            Thread.sleep(TEST_DELAY);

            pos.hide();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new TestResult(true, null);

    }

    /**
     * Performs a basic grid boundaries, grid position color && movement test
     *
     * @param grid   graphics library associated grid object
     * @param cycles number of laps the grid's position will make round the grid
     * @return test result flag
     */
    private static TestResult finalStep(SimpleGfxGrid grid, int cycles) {

        GridPosition pos = grid.makeGridPosition(0, 0);
        pos.setColor(GridColor.BLUE);

        List<Shape> shapes = Canvas.getInstance().getShapes();
        Shape gridPos = shapes.toArray(new Shape[shapes.size()])[1];

        try {

            while (cycles > 0) {

                pos.setColor(cycles % 2 == 0 ? GridColor.BLUE : GridColor.RED);
                cycles--;

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.DOWN, TEST_STEP);

                if (pos.getRow() >= ROW_NUM) {
                    return new TestResult(false, "position coordinates are wrong after moving down");
                }

                if (gridPos.getX() != pos.getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING
                        || gridPos.getY() != pos.getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING) {
                    return new TestResult(false, "shape position coordinates are wrong after moving down");
                }


                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.RIGHT, TEST_STEP);

                if (pos.getCol() >= COL_NUM) {
                    return new TestResult(false, "position coordinates are wrong");
                }

                if (gridPos.getX() != pos.getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING
                        || gridPos.getY() != pos.getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING) {
                    return new TestResult(false, "shape position coordinates are wrong after moving right");
                }

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.UP, TEST_STEP);

                if (pos.getRow() < 0) {
                    return new TestResult(false, "position coordinates are wrong");
                }

                if (gridPos.getX() != pos.getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING
                        || gridPos.getY() != pos.getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING) {
                    return new TestResult(false, "shape position coordinates are wrong after moving up");
                }

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.LEFT, TEST_STEP);

                if (pos.getCol() < 0) {
                    return new TestResult(false, "position coordinates are wrong");
                }

                if (gridPos.getX() != pos.getCol() * grid.getCellSize() + SimpleGfxGrid.PADDING
                        || gridPos.getY() != pos.getRow() * grid.getCellSize() + SimpleGfxGrid.PADDING) {
                    return new TestResult(false, "shape position coordinates are wrong after moving left");
                }

                Thread.sleep(TEST_DELAY);
                pos.hide();

                Thread.sleep(TEST_DELAY);
                pos.show();

            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return new TestResult(true, null);

    }

    private static void assertCondition(String test, TestResult result) {

        System.out.println(test + ": " + (result.pass ? "OK" : "FAIL"));
        if (!result.pass) {
            System.out.println(" => " + result.message);
        }

    }

    private static class TestResult {

        public boolean pass = true;
        public String message;

        public TestResult(boolean pass, String message) {
            this.pass = pass;
            this.message = message;
        }
    }

}
