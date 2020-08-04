package tech.geek.flu.multi.thread.deadlock;

import java.util.Random;

public class Train implements Runnable {
    private Intersection intersection;
    private Random random = new Random();
    private String road;

    public Train(Intersection intersection, String road) {
        this.intersection = intersection;
        this.road = road;
    }

    @Override
    public void run() {
        while (true) {
            long sleepingTime = random.nextInt(5);
            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(road.equals("A")) {
                intersection.takeRoadA();
            }else {
                intersection.takeRoadB();
            }
        }
    }


}
