package tech.geek.flu.multi.thread.vault;

import lombok.SneakyThrows;

public class PoliceThread extends Thread {


    @SneakyThrows
    @Override
    public void run() {
        for (int i = 10 ; i > 0 ; i--) {
            Thread.sleep(1000);
            System.out.println("I am counting: " + i);
        }

        System.out.println("Game over Punks!!!!");
        System.exit(0);
    }
}
