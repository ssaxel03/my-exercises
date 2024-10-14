package io.codeforall.fanstatics;

import java.util.PriorityQueue;

public class ToDoList {

   PriorityQueue<Task> priorityQueue;

   public ToDoList() {
       this.priorityQueue = new PriorityQueue<Task>();
   }

    public void add(Importance importance, int priority, String item) {
       this.priorityQueue.offer(new Task(importance, priority, item));
    }

    public String remove() {
       return this.priorityQueue.remove().getItem();
    }

    public boolean isEmpty(){
       return this.priorityQueue.isEmpty();
    }
}
