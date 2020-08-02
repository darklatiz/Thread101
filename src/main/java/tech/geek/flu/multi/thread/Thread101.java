package tech.geek.flu.multi.thread;

public class Thread101 {

    public static void main(String[] args) throws InterruptedException {

        Thread th = new Thread(() -> {
            System.out.println("We are NOW in Thread: " + Thread.currentThread().getName());
            System.out.println("Current Priority: " + Thread.currentThread().getPriority());
        });

        Thread errorTh = new Thread(() -> {
            throw  new RuntimeException("Intentional Error");
        });

        errorTh.setName("Buggy Thread");
        errorTh.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("Error Handler********************");
                System.out.println(thread.getName());
                System.out.println(throwable.getLocalizedMessage());
            }
        });
        th.setName("Worker Thread");
        th.setPriority(Thread.MAX_PRIORITY);
        System.out.println("WE are in Thread: " + Thread.currentThread().getName() + " Before:::::");
        th.start();
        System.out.println("WE are in Thread: " + Thread.currentThread().getName() + " After::::::");
        errorTh.start();

        Thread threadStaticClass = new TaskXxx();
        threadStaticClass.start();

        Thread.sleep(10000);
    }

    private static class TaskXxx extends Thread {
        @Override
        public void run() {
           System.out.println("Via Statis class...");
        }
    }
}
