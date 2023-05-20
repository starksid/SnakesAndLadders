package movingStrategy;

import snakeAndLadder.Board;
import snakeAndLadder.Cell;
import snakeAndLadder.CellState;
import snakeAndLadder.Player;

public class LadderMovingStrategy implements MovingStrategy{
    @Override
    public void makeMove(Player player, Board board, Cell cell) {
        int P = player.getNumber();
        Cell cell1 = board.getIntegerCellMap().get(P);
        player.setNumber(cell1.getEndPosition());
        int P1 = player.getNumber();
        Cell cell2 = board.getIntegerCellMap().get(P1);
        if(cell2.getCellState().equals(CellState.SNAKE)){
            player.setNumber(cell2.getEndPosition());
        }
    }
}
