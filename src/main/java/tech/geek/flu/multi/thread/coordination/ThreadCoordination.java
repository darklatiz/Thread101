package tech.geek.flu.multi.thread.coordination;

public class ThreadCoordination {

    public static void main(String[] args) {
        Thread blockingThread = new Thread(new BlockingThread());
        blockingThread.start();
        blockingThread.interrupt();
    }

    private static class BlockingThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Some other Thread has interrupted this thread, we are out bitch...");
            }
        }
    }

}
