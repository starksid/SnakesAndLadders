package definningCell;


import movingStrategy.MovingStrategy;
import snakeAndLadder.Cell;
import snakeAndLadder.CellState;

public interface DefinningCell {
    void makeCell(Cell cell, CellState cellState, int start, int end, MovingStrategy movingStrategy);

}
