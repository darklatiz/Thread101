package tech.geek.flu.multi.thread.join;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentFactorial {

    public static void main(String[] args) throws InterruptedException {
        List<Long> numbers = List.of(10000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5566L);
        List<FactorialThread> threads = new ArrayList<>();
        for (Long n : numbers) {
            threads.add(new FactorialThread(n));
        }

        for (Thread th : threads) {
            //th.setDaemon(true); //if we add this line after timeout form join is finished all the threads will be finisehd even if still running
            th.start();
        }

        //All the threads will have to finish in order to return control to the main thread, if we use a timeout the control will be returned to main thread after the timeout
        for (Thread th : threads) {
            th.join(2500);
        }

        System.out.println("Timeout of join main");

        for(int lion = 0; lion < numbers.size(); lion++) {
            FactorialThread factorialThread = threads.get(lion);
            if(factorialThread.isFinished()) {
                System.out.println("Factorial of " + numbers.get(lion) + " is done");
            }else {
                System.out.println("The calculation for " + numbers.get(lion) + " is still in progress");
                factorialThread.interrupt();
            }
        }


    }


}
