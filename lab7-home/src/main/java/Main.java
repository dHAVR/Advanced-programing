import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numPlayers = 3;
        int n = 3; // Length of the sequence
        Bag bag = new Bag(n);

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1), bag, n));
        }

        TimeKeeper timeKeeper = new TimeKeeper(30000); // 30 seconds time limit
        timeKeeper.setDaemon(true);
        timeKeeper.start();

        for (Player player : players) {
            player.start();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Player winner = determineWinner(players);
        System.out.println("The winner is: " + winner.getName() + " with the longest sequence.");
    }

    private static Player determineWinner(List<Player> players) {
        Player winner = players.get(0);
        int maxSequenceValue = 0;
        for (Player player : players) {
            for (List<String> sequence : player.getSequences()) {
                if (sequence.size() > maxSequenceValue) {
                    maxSequenceValue = sequence.size();
                    winner = player;
                }
            }
        }
        return winner;
    }
}