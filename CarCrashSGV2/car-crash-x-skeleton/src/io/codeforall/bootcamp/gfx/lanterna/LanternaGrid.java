package io.codeforall.bootcamp.gfx.lanterna;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import io.codeforall.bootcamp.grid.Grid;
import io.codeforall.bootcamp.grid.position.GridPosition;

/**
 * A Grid based on the Lanterna library
 * This implementation DOES NOT contain keyboard support
 */
public class LanternaGrid implements Grid {

    /**
     * Used to write to screen
     */
    private static Screen screen;

    /**
     * Screen wrapper that preserves default options
     */
    private static ScreenWriter screenWriter;

    private int cols;
    private int rows;

    /**
     * Constructs a grid with a specific number of columns and rows
     *
     * @param cols number of grid columns
     * @param rows number of grid rows
     */
    public LanternaGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        // create the GUI
        screen = TerminalFacade.createScreen();

        // set the grid size
        screen.getTerminal().setCursorVisible(false); // Not Working
        screen.getTerminal().getTerminalSize().setColumns(cols);
        screen.getTerminal().getTerminalSize().setRows(rows);

        // display the grid
        screen.startScreen();

    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition(){
        return new LanternaGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new LanternaGridPosition(col, row, this);
    }

    /**
     * Show a specific grid position on screen
     *
     * @param pos the grid position to show
     */
    public void show(GridPosition pos) {
        screen.putString(pos.getCol(), pos.getRow(), " ", LanternaColorMapper.getColor(pos.getColor()), LanternaColorMapper.getColor(pos.getColor()));
        screen.refresh();
    }

    /**
     * Hide a specific grid position
     *
     * @param pos the grid position to hide
     */
    public void hide(GridPosition pos) {
        screen.putString(pos.getCol(), pos.getRow(), " ", Terminal.Color.DEFAULT, Terminal.Color.DEFAULT);
        screen.refresh();
    }

}
