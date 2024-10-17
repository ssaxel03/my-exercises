package io.codeforall.fanstatics;

public class Main {

    public static void main(String[] args) {

        ProgramManager programManager = new ProgramManager(50, 20);

        programManager.init();

        try {
            programManager.run();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
