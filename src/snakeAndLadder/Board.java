package snakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Cell[][] board;
    private Map<Integer, Cell> integerCellMap;
    private Map<Cell, Integer> CellintegerMap;
    public Board(int dimension){
        board = new Cell[dimension][dimension];
        integerCellMap = new HashMap<>();
        CellintegerMap = new HashMap<>();
        int k = 1;
        for(int i = 0; i<dimension; i++){
            if(i%2==0){
                for(int j=0; j<dimension; j++){
                    board[i][j] = new Cell(i, j, k, k, k, CellState.EMPTY);
                    integerCellMap.put(k, board[i][j]);
                    CellintegerMap.put(board[i][j], k);
                    k+=1;
                }
            }else{
                for(int j=dimension-1; j>=0; j--){
                    board[i][j] = new Cell(i, j, k, k, k, CellState.EMPTY);
                    integerCellMap.put(k, board[i][j]);
                    CellintegerMap.put(board[i][j], k);
                    k+=1;
                }
            }

        }
    }
    public void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print("| " + board[i][j].getCellNumber() + " |" );
            }
            System.out.print("\n");
        }
    }

    public Map<Cell, Integer> getCellintegerMap() {
        return CellintegerMap;
    }

    public void setCellintegerMap(Map<Cell, Integer> cellintegerMap) {
        CellintegerMap = cellintegerMap;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Map<Integer, Cell> getIntegerCellMap() {
        return integerCellMap;
    }

    public void setIntegerCellMap(Map<Integer, Cell> integerCellMap) {
        this.integerCellMap = integerCellMap;
    }
}
