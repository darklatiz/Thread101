package tech.geek.flu.multi.thread.coordination;

import java.math.BigInteger;

public class ThreadCoordination02 {

    public static void main(String[] args) {
        Thread longComputation = new Thread(new LongComputation(new BigInteger("200000"), new BigInteger("1000000")));
        longComputation.start();

        longComputation.interrupt();
    }

    private static class LongComputation implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputation(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(this.base + "^" + this.power + " = " + this.pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger res = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("The thread has been interrupted....");
                    return BigInteger.ZERO;
                }
                res = res.multiply(base);
            }
            return res;
        }
    }
}
