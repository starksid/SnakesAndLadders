package movingStrategy;

import snakeAndLadder.Board;
import snakeAndLadder.Cell;
import snakeAndLadder.Player;

public interface MovingStrategy {
    public void makeMove(Player player, Board board, Cell cell);
}
