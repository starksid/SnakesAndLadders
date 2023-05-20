package snakeAndLadder;

public class Player {
    private String Name;
    private int Number;
    private String Color;
    private PlayerState playerState;
    public Player(String Name, String Color, PlayerState playerState){
        this.Color = Color;
        this.Name = Name;
        this.playerState = PlayerState.TO_GET_IN_PROGRESS;
        this.Number = 0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
