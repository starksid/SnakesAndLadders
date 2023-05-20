package snakeAndLadder;

import definningCell.DefinningCell;
import definningCell.LadderDefinningCell;
import definningCell.SnakeDefinningCell;
import movingStrategy.LadderMovingStrategy;
import movingStrategy.MovingStrategy;
import movingStrategy.SnakeBiteMovingStrategy;

import java.util.*;

public class Game {
    Scanner sc = new Scanner(System.in);
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Dice dice;
    private int currentPlayerIndex;
    private Set<MovingStrategy> movingStrategies;
    private Game(){}
    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }



    public List<Move> getMoves() {
        return moves;
    }



    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Dice getDice() {
        return dice;
    }
    public void printBoard(){
        board.printBoard();
    }
    public void MakeMove(){
        Player player = players.get(currentPlayerIndex);
        currentPlayerIndex +=1;
        currentPlayerIndex%=players.size();
        System.out.println(player.getName() + player.getColor() + " Please roll the dice [Tap anything on the keyboard]");
        char c = sc.next().charAt(0);
        int Number = dice.getNumber();
        System.out.println(player.getName() + player.getColor() + " You got this Number "+ Number);
        if(player.getPlayerState().equals(PlayerState.TO_GET_IN_PROGRESS)) {
            if (Number == 1 || Number == 6) {
                player.setPlayerState(PlayerState.IN_PROGRESS);
                System.out.println(player.getName() + " You are in_progress");
                int N = player.getNumber();
                player.setNumber(N + Number);
            }
        } else {
                int N = player.getNumber()+Number;
                if(N<=100){
                    player.setNumber(N);
                }

        }

        int currPosition = player.getNumber();
        if(currPosition==100){
            System.out.println(player.getName() + " with " + player.getColor() + " color has Won the Game.");
            gameStatus = GameStatus.SUCCESS;
        }else if(player.getPlayerState().equals(PlayerState.IN_PROGRESS)){
            Cell cell = board.getIntegerCellMap().get(currPosition);
            while (cell.getCellState().equals(CellState.LADDER) || cell.getCellState().equals(CellState.SNAKE)){
                if (cell.getCellState().equals(CellState.LADDER)){
                    MovingStrategy movingStrategy = cell.getMovingStrategy();
                    movingStrategy.makeMove(player, board, cell);
                } else if (cell.getCellState().equals(CellState.SNAKE)) {
                    MovingStrategy movingStrategy = cell.getMovingStrategy();
                    movingStrategy.makeMove(player, board, cell);
                }
                int currNum = player.getNumber();
                cell = board.getIntegerCellMap().get(currNum);
            }
            if(currPosition==100){
                System.out.println(player.getName()+ " with " + player.getColor() + " color has Won the Game.");
            }

        }
        for(int k =0; k<players.size(); k++){
            System.out.println(players.get(k).getName() + players.get(k).getColor() + " is at this " + players.get(k).getNumber() + " position." );
        }




    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        List<Player> players;
        int dimension;


        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }



        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public void createSnakesAndLadders(Board board){
            List<Integer> SnakesStart = new ArrayList<>();
            List<Integer> SnakesEnd = new ArrayList<>();
            SnakesStart.add(36);
            SnakesStart.add(49);
            SnakesStart.add(56);
            SnakesStart.add(87);
            SnakesStart.add(95);
            SnakesStart.add(82);
            SnakesEnd.add(5);
            SnakesEnd.add(7);
            SnakesEnd.add(8);
            SnakesEnd.add(66);
            SnakesEnd.add(38);
            SnakesEnd.add(20);
            List<Integer> LaddersStart = new ArrayList<>();
            List<Integer> LadderEnd = new ArrayList<>();
            LaddersStart.add(5);
            LaddersStart.add(9);
            LaddersStart.add(23);
            LaddersStart.add(48);
            LaddersStart.add(62);
            LaddersStart.add(69);
            LadderEnd.add(35);
            LadderEnd.add(51);
            LadderEnd.add(42);
            LadderEnd.add(86);
            LadderEnd.add(95);
            LadderEnd.add(91);
            DefinningCell definningCell = new SnakeDefinningCell();
            DefinningCell definningCell1 = new LadderDefinningCell();
            for(int i =0; i<SnakesStart.size(); i++){
                int start = SnakesStart.get(i);
                int end = SnakesEnd.get(i);
                Cell cell = board.getIntegerCellMap().get(start);
                definningCell.makeCell(cell, CellState.SNAKE, start, end, new SnakeBiteMovingStrategy());
                int S = LaddersStart.get(i);
                int E = LadderEnd.get(i);
                Cell cell1 = board.getIntegerCellMap().get(S);
                definningCell1.makeCell(cell1, CellState.LADDER, S, E, new LadderMovingStrategy());


            }



        }
        public Game build(){
            Game game = new Game();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.dice = new Dice();
            game.moves = new ArrayList<>();
            game.board = new Board(dimension);
            game.players = players;
            game.currentPlayerIndex = 0;
            this.createSnakesAndLadders(game.board);




            return game;
        }

    }


}
