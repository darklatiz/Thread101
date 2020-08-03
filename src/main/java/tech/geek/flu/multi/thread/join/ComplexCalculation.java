package tech.geek.flu.multi.thread.join;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread op1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread op2 = new PowerCalculatingThread(base2, power2);

        op1.start();
        op2.start();

        try {
            op1.join();
            op2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        result = op1.getResult().add(op2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            BigInteger res = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("The thread has been interrupted....");
                    this.result = BigInteger.ZERO;
                    break;
                }
                this.result = this.result.multiply(base);
            }
        }

        public BigInteger getResult() { return result; }
    }

    public static void main(String[] args) {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger result = complexCalculation.calculateResult(new BigInteger("2"), new BigInteger("2"), new BigInteger("2"), new BigInteger("2"));
        System.out.println(result);
    }
}