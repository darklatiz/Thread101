package tech.geek.flu.multi.thread.vault;

public class AscendingHackerThread extends Hacker{
    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < MAX_PASSWORD; i++) {
            if(vault.isCorrectPassword(i)) {
                System.out.println("Password has been guessed: " + i + " , by Hacker: " + this.getName());
                System.exit(0);
            }else {
                System.out.println("Password tried, it did not work: " + i + " , by Hacker: " + this.getName());

            }
        }
    }
}
