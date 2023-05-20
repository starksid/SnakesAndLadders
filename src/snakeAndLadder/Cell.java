package snakeAndLadder;

import movingStrategy.MovingStrategy;
import movingStrategy.NormalMovingStrategy;
import snakeAndLadder.Player;
public class Cell {
    private int cellNumber;
    private int row;
    private int col;
    MovingStrategy movingStrategy;

    int startPosition;
    int endPosition;
    public Cell(int row, int col, int cellNumber, int startPosition, int endPosition, CellState cellState){
        this.row =row;
        this.col = col;
        this.cellNumber = cellNumber;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.cellState = cellState;
        this.movingStrategy = new NormalMovingStrategy();

    }

    public MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }



    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    CellState cellState;






}
