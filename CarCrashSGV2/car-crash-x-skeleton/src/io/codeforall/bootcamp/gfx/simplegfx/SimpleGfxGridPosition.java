package io.codeforall.bootcamp.gfx.simplegfx;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.AbstractGridPosition;
import io.codeforall.bootcamp.grid.position.GridPosition;
import io.codeforall.bootcamp.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private GridColor gridColor;

    /**
     * Simple graphics position constructor
     *
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid) {
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.rectangle = new Rectangle(grid.columnToX(this.getCol()), grid.rowToY(this.getRow()), grid.getCellSize(), grid.getCellSize());

        this.rectangle.fill();

        this.simpleGfxGrid = grid;
    }

    /**
     * Simple graphics position constructor
     *
     * @param col  position column
     * @param row  position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.rectangle = new Rectangle(grid.columnToX(col),
                grid.rowToY(row),
                grid.getCellSize(),
                grid.getCellSize());

        this.rectangle.fill();

        this.simpleGfxGrid = grid;
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        this.rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        this.rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        /*switch (direction) {
            // TESTADO E APROVADO - 0 ERROS - PERFEITO
            /* case UP:
                if (this.getRow() - (distance / simpleGfxGrid.getCellSize()) < SimpleGfxGrid.PADDING) {
                    break;
                }
                this.rectangle.translate(0, -distance);
                this.setPos(this.getCol(), this.getRow() - (distance / simpleGfxGrid.getCellSize()));
            case DOWN:
                if (this.getRow() + (distance / simpleGfxGrid.getCellSize()) > simpleGfxGrid.getRows()) {
                    break;
                }
                this.rectangle.translate(0, distance);
                this.setPos(this.getCol(), this.getRow() + (distance / simpleGfxGrid.getCellSize()));
            case LEFT:
                if (this.getCol() - (distance / simpleGfxGrid.getCellSize()) < SimpleGfxGrid.PADDING) {
                    break;
                }
                this.rectangle.translate(-distance, 0);
                this.setPos(this.getCol() - (distance / simpleGfxGrid.getCellSize()), this.getRow());
            case RIGHT:
                if (this.getCol() + (distance / simpleGfxGrid.getCellSize()) < simpleGfxGrid.getCols()) {
                    break;
                }
                this.rectangle.translate(distance, 0);
                this.setPos(this.getCol() + (distance / simpleGfxGrid.getCellSize()), this.getRow());
        }


             */

        super.moveInDirection(direction, distance);

        this.rectangle.translate(simpleGfxGrid.columnToX(this.getCol()) - this.rectangle.getX(),
                (simpleGfxGrid.rowToY(this.getRow()) - this.rectangle.getY()));
        // this.rectangle
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        this.gridColor = color;

        switch (color) {
            case RED -> this.rectangle.setColor(Color.RED);
            case BLUE -> this.rectangle.setColor(Color.BLUE);
            case GREEN -> this.rectangle.setColor(Color.GREEN);
            case MAGENTA -> this.rectangle.setColor(Color.MAGENTA);
        }
    }

    public GridColor getColor() {
        return this.gridColor;
    }
}
