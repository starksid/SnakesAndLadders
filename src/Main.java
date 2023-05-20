import gamecontroller.GameController;
import snakeAndLadder.Game;
import snakeAndLadder.GameStatus;
import snakeAndLadder.Player;
import snakeAndLadder.PlayerState;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("please insert number of players are players: ");
        int N = sc.nextInt();
        for(int i =0 ; i<N; i++){
            System.out.println("Please insert your Name");
            String Name = sc.next();
            System.out.println("Please insert Your Favourite color: ");
            String Color = sc.next();
            players.add(new Player(Name, Color, PlayerState.TO_GET_IN_PROGRESS));
        }

        int dimension = 10;
        Game game = gameController.startGame(players, dimension);
        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.makeMove(game);

        }
    }
}
