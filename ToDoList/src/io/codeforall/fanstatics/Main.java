package io.codeforall.fanstatics;

public class Main {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.add(Importance.MEDIUM, 1, "Medium priority 1");
        toDoList.add(Importance.LOW, 1, "Low priority 1");
        toDoList.add(Importance.HIGH, 1, "High priority 1");
        toDoList.add(Importance.MEDIUM, 2, "Medium priority 2");
        toDoList.add(Importance.LOW, 2, "Low priority 2");
        toDoList.add(Importance.HIGH, 2, "High priority 2");

        while(!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }



}
