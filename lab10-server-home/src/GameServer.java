import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import gameLogic.Player;

public class GameServer {
    private static final int PORT = 1234;
    private ConcurrentMap<String, Player> players = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientThread(clientSocket, this).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addPlayer(String name, Player player) {
        players.put(name, player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }
}
