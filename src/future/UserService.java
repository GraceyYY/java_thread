package future;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class UserService {
    private HashMap<String, User> customers;

    public UserService() {
        this.customers = new HashMap<>();
    }

    public void addUser(User user) {
        this.customers.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return this.customers.get(id);
    }

    public CompletableFuture<User> getUserByIdAsync(String id) {
        return CompletableFuture.supplyAsync(() -> this.getUserById(id));
    }
}
