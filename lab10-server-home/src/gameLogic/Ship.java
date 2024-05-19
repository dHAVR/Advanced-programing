package gameLogic;

public class Ship {
    private int length;
    private boolean horizontal;

    public Ship(int length, boolean horizontal) {
        this.length = length;
        this.horizontal = horizontal;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}
