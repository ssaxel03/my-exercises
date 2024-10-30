package io.codeforall.fanstatics;

public class Main {

    public static void main(String[] args) {

        Machine machine = new Machine();

        System.out.println(machine.sum.execute(1, 2));
        System.out.println(machine.subtract.execute(5, 7));
        System.out.println(machine.multiply.execute(9, 5));
        System.out.println(machine.divide.execute(10f, 2f));
        System.out.println(machine.sqrt.execute(4f));
        System.out.println(machine.square.execute(2));

        System.out.println(machine.upperCase.execute("axel"));
        System.out.println(machine.lowerCase.execute("AXEL"));
    }

}
