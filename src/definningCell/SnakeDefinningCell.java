package definningCell;

import movingStrategy.MovingStrategy;
import snakeAndLadder.Cell;
import snakeAndLadder.CellState;

public class SnakeDefinningCell implements DefinningCell{
    @Override
    public void makeCell(Cell cell, CellState cellState, int start, int end, MovingStrategy movingStrategy) {
        cell.setStartPosition(start);
        cell.setEndPosition(end);
        cell.setCellState(CellState.SNAKE);
        cell.setMovingStrategy(movingStrategy);
    }
}
