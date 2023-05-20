package gamecontroller;

import snakeAndLadder.CellState;
import snakeAndLadder.Game;
import snakeAndLadder.GameStatus;
import snakeAndLadder.Player;

import java.util.List;

public class GameController {
    public Game startGame(List<Player> players, int dimension){
        return Game.getBuilder().setDimension(dimension).setPlayers(players).build();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public void makeMove(Game game){
        game.MakeMove();
    }
}
