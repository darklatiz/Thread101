package tech.geek.flu.multi.thread.vault;

import java.util.List;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(Hacker.MAX_PASSWORD));
        List<Thread> threads = List.of(
                new AscendingHackerThread(vault),
                new DescendingHacker(vault),
                new PoliceThread());

        for (Thread t : threads) {
            t.start();
        }
    }
}
