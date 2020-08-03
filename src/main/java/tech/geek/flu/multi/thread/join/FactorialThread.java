package tech.geek.flu.multi.thread.join;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class FactorialThread extends Thread{
    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(this.inputNumber);
        this.isFinished = true;
    }

    public BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = n; i > 0 ; i--) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Thread for calculation " + this.inputNumber + " has been interrupted");
                return BigInteger.ZERO;
            }
            result = result.multiply(new BigInteger(Long.toString(i)));
        }
        return result;
    }
}
