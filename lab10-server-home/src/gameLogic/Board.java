package gameLogic;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private char[][] grid;
    private Random random;

    public Board() {
        grid = new char[10][10];
        for (char[] row : grid) {
            Arrays.fill(row, '~');
        }
        random = new Random();
    }

    public boolean placeShip(Ship ship, int row, int col) {
        int length = ship.getLength();
        boolean horizontal = ship.isHorizontal();

        if (horizontal) {

            if (col + length > 10) return false;
            for (int i = 0; i < length; i++) {
                if (grid[row][col + i] != '~') return false;
            }
            for (int i = 0; i < length; i++) {
                grid[row][col + i] = 'S';
            }
        } else {

            if (row + length > 10) return false;
            for (int i = 0; i < length; i++) {
                if (grid[row + i][col] != '~') return false;
            }
            for (int i = 0; i < length; i++) {
                grid[row + i][col] = 'S';
            }
        }

        return true;
    }

    public boolean placeShipsRandomly(Ship[] ships) {
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(10);
                int col = random.nextInt(10);
                boolean horizontal = random.nextBoolean();
                ship.setHorizontal(horizontal);
                placed = placeShip(ship, row, col);
            }
        }
        return true;
    }

    public boolean receiveAttack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';
            return true;
        } else if (grid[row][col] == '~') {
            grid[row][col] = 'O';
            return false;
        } else {

            return false;
        }
    }

    public boolean isAllShipsSunk() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'S') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
