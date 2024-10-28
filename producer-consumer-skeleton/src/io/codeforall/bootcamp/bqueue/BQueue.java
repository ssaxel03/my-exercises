package io.codeforall.bootcamp.bqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private LinkedList<T> queue;
    private final int limit;

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {
        System.out.println("Queue created");
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while(this.isFull()) {
            try {
                System.out.println(Thread.currentThread().getName() + " tried to produce a pizza but the queue is full");
                wait();
            } catch (InterruptedException e) {}
        }

        System.out.println(Thread.currentThread().getName() + " produced a pizza");

        this.queue.offer(data);
        notifyAll();
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        while(this.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " tried to consume a pizza but the queue is empty");
                wait();
            } catch (InterruptedException e) {}
        }

        System.out.println(Thread.currentThread().getName() + " consumed a pizza");
        T poll = this.queue.poll();
        notifyAll();
        return poll;

    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public synchronized int getSize() {

        return this.queue.size();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return this.limit;

    }

    public synchronized boolean isFull() {
        return this.queue.size() == this.limit;
    }

    public synchronized boolean isEmpty() {
        return this.queue.size() == 0;
    }

}
