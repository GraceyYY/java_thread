package future;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class BankService {
    private HashMap<User, Card> info;

    public BankService() {
        this.info = new HashMap<>();
    }

    public void addUser(User user, Card card) {
        this.info.put(user, card);
    }

    public Card getCardByUser(User user) {
        return this.info.get(user);
    }

    public CompletableFuture<Card> getCardByUserAsync(User user) {
        return CompletableFuture.supplyAsync(() -> this.getCardByUser(user));
    }
}
