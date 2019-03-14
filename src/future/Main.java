package future;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        BankService bankService = new BankService();

        User user1 = new User("张三", "1");
        User user2 = new User("李四", "2");
        User user3 = new User("王五", "3");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        bankService.addUser(user1, new Card("123", "农行卡", 100));
        bankService.addUser(user2, new Card("234", "建行卡", 500));

        CompletableFuture<Card> cardOfUser1 = userService.getUserByIdAsync("1").thenCompose(user -> bankService.getCardByUserAsync(user));
        CompletableFuture<Card> cardOfUser2 = userService.getUserByIdAsync("2").thenCompose(user -> bankService.getCardByUserAsync(user));

        try {
            int creditOfUser1 = cardOfUser1.get().getCredit();
            int creditOfUser2 = cardOfUser2.get().getCredit();
            int totalCredit = creditOfUser1 + creditOfUser2;
            System.out.println("张三和李四共有：" + totalCredit + "元。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
