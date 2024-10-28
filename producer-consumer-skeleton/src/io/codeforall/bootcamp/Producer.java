package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.BQueue;
import io.codeforall.bootcamp.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        while(true) {

            for (int i = 0; i < elementNum; i++) {
                queue.offer(new Pizza());
            }

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {}

        }
    }

    public int getElementNum() {
        return this.elementNum;
    }

}
