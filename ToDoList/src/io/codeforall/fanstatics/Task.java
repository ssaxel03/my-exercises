package io.codeforall.fanstatics;

import java.util.Comparator;

public class Task implements Comparable<Task> {

    private Importance importance;
    private int priority;
    private String item;

    public Task(Importance importance, int priority, String item){
        this.importance = importance;
        this.priority = priority;
        this.item = item;
    }

    @Override
    public int compareTo(Task task) {

        if(this.importance.getImportanceValue() == task.importance.getImportanceValue()) {
            return this.priority - task.priority;
        }

        return this.importance.getImportanceValue() - task.importance.getImportanceValue();

    }

    public String getItem() {
        return this.item;
    }
}
