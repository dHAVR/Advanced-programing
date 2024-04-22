
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

class Bag {
    private List<Token> tokens;

    public Bag(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tokens.add(new Token(i, j));
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token extractToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(0);
        }
        return null;
    }
}