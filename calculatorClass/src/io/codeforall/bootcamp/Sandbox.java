package io.codeforall.bootcamp;
import java.util.Scanner;

public class Sandbox {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        /*
        Calculator calc = new Calculator();

        System.out.println("Counter: " + calc.getCounter());
        calc.Add(10);
        calc.Add(7.5);
        calc.Subtract(9);
        calc.Subtract(1.5);
        System.out.println("Counter: " + calc.getCounter());
        */
        int opt = 0;

        while(opt != 2) {
            System.out.println("1 - Começar 2 - Sair");
            opt = Integer.parseInt(myScan.nextLine());
            if(opt == 1) {

                String name;
                int age;
                String funFact;
                String greet;

                System.out.println("Nome, idade e funfact do MasterCoder?");
                name = myScan.nextLine();
                age = Integer.parseInt(myScan.nextLine());
                funFact = myScan.nextLine();

                MasterCoder mastCoder = new MasterCoder(name, age, funFact);

                System.out.print("Cumprimenta o MasterCoder: ");
                greet = myScan.nextLine();

                mastCoder.Greet();
                String forward = myScan.nextLine();

            }
        }

        System.out.println("O Mekie é totó");
    }
}
