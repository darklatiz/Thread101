package tech.geek.flu.multi.thread.vault;

import lombok.SneakyThrows;

public class DescendingHacker extends  Hacker{
    public DescendingHacker(Vault vault) {
        super(vault);
    }

    @SneakyThrows
    @Override
    public void run() {
       for (int j = MAX_PASSWORD ; j >= 0; j--) {
           if(vault.isCorrectPassword(j)) {
               System.out.println("Password has been guessed: " + j + " , by Hacker: " + this.getName());
               System.exit(0);
           }else {
               System.out.println("Password tried, it did not work: " + j + " , by Hacker: " + this.getName());
           }
       }
    }
}
