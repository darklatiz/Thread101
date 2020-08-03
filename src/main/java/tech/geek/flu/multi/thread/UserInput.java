package tech.geek.flu.multi.thread;

import java.io.IOException;

public class UserInput {

    public static void main(String[] args) {
        Thread thread = new Thread(new UserInputThread());
        thread.setName("UserInputThread");
        thread.setDaemon(true); // if we set the property to false the only way to stop the app is to use q to stop it, if we try to use interrup method we need to check if it was interrupte
        thread.start();
    }

    private static class UserInputThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if(input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }
}
