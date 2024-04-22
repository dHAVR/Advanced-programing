import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

class Player extends Thread {
    private String name;
    private List<List<String>> sequences;
    private Bag bag;
    private int n;

    public Player(String name, Bag bag, int n) {
        this.name = name;
        this.bag = bag;
        this.sequences = new ArrayList<>();
        this.n = n;
    }

    public void run() {
        while (true) {
            List<Token> sequence = new ArrayList<>();
            Token token;
            while (sequence.size() < n && (token = bag.extractToken()) != null) {
                if (isValidToken(sequence, token)) {
                    sequence.add(token);
                } else {
                    break;
                }
            }
            if (sequence.size() == n || sequence.isEmpty()) {
                break;
            }
            sequences.add(getTokenPairs(sequence));
        }
        System.out.println(name + " finished with sequences: " + sequences);
    }

    private boolean isValidToken(List<Token> sequence, Token token) {
        if (sequence.isEmpty()) {
            return true;
        }
        Token lastToken = sequence.get(sequence.size() - 1);
        return lastToken.getNum2() == token.getNum1();
    }

    private List<String> getTokenPairs(List<Token> tokens) {
        List<String> pairs = new ArrayList<>();
        for (Token token : tokens) {
            pairs.add("(" + token.getNum1() + "," + token.getNum2() + ")");
        }
        return pairs;
    }

    public List<List<String>> getSequences() {
        return sequences;
    }
}
