package tech.geek.flu.multi.thread.vault;

public abstract class Hacker extends Thread {

    public static int MAX_PASSWORD = 9999;
    protected Vault vault;

    public Hacker(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void run() {
        System.out.println("Starting Thread " + this.getPriority());
        super.run();
    }
}
