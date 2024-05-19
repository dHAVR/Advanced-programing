import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import gameLogic.Player;
import gameLogic.Board;
import gameLogic.Ship;

public class ClientThread extends Thread {
    private Socket socket;
    private GameServer server;
    private PrintWriter output;
    private BufferedReader input;

    public ClientThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String command;
            while ((command = input.readLine()) != null) {
                System.out.println("Received command: " + command);
                String[] parts = command.split(" ");
                switch (parts[0].toLowerCase()) {
                    case "create":
                        handleCreateGame(parts);
                        break;
                    case "join":
                        handleJoinGame(parts);
                        break;
                    case "move":
                        handleMove(parts);
                        break;
                    case "stop":
                        output.println("Server stopped");
                        break;
                    default:
                        output.println("Invalid command");
                }
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void handleCreateGame(String[] parts) {
        if (parts.length == 2) {
            String playerName = parts[1];
            Player player = new Player(playerName);
            Board board = new Board();

            Ship[] ships = {
                    new Ship(4, true),
                    new Ship(3, false),
                    new Ship(3, true),
                    new Ship(2, false),
                    new Ship(2, true),
                    new Ship(2, false),
                    new Ship(1, true),
                    new Ship(1, false),
                    new Ship(1, true),
                    new Ship(1, false)
            };

            board.placeShipsRandomly(ships);

            player.setBoard(board);
            server.addPlayer(playerName, player);
            output.println("Game created for player: " + playerName);
            board.printBoard();

            player.startTimer(60);
        } else {
            output.println("Invalid create command");
        }
    }

    private void handleJoinGame(String[] parts) {
        if (parts.length == 2) {
            String playerName = parts[1];
            Player player = server.getPlayer(playerName);
            if (player != null) {
                output.println("Joined game for player: " + playerName);
                player.getBoard().printBoard(); // Выводим доску в консоль клиента для проверки

                // Запуск таймера
                player.startTimer(60); // Например, 60 секунд на игру
            } else {
                output.println("Player not found");
            }
        } else {
            output.println("Invalid join command");
        }
    }

    private void handleMove(String[] parts) {

        if (parts.length == 4) {
            String playerName = parts[1];
            int row = Integer.parseInt(parts[2]);
            int col = Integer.parseInt(parts[3]);
            Player player = server.getPlayer(playerName);
            if (player != null) {
                boolean hit = player.getBoard().receiveAttack(row, col);
                output.println(hit ? "Hit!" : "Miss!");


                player.stopTimer();
                player.startTimer(60); // Перезапуск таймера после хода


                if (player.getBoard().isAllShipsSunk()) {
                    output.println("All ships sunk! Player " + playerName + " loses!");
                    player.stopTimer();
                }
            } else {
                output.println("Player not found");
            }
        } else {
            output.println("Invalid move command");
        }
    }
}
