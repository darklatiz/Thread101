package tech.geek.flu.multi.thread.vault;

public class Vault {

    private int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int oPassword) throws InterruptedException {
        Thread.sleep(5);
        return this.password == oPassword;
    }
}
