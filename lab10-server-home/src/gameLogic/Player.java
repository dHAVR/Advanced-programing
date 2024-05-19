package gameLogic;

public class Player {
    private String name;
    private Board board;
    private TimeControl timeControl;

    public Player(String name) {
        this.name = name;
        this.board = new Board();
        this.timeControl = new TimeControl(() -> {
            System.out.println("Player " + name + " has run out of time and loses the game!");

        });
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void startTimer(int seconds) {
        timeControl.startTimer(seconds);
    }

    public void stopTimer() {
        timeControl.stopTimer();
    }
}
