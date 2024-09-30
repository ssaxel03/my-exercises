package io.codeforall.fanSTATICs_;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class InputManager{

    public static void start() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Bank name:");
        String bankName = scan.nextLine();
        Bank bank = new Bank(bankName);

        System.out.println("Person name:");
        String personName = scan.nextLine();

        int job;

        while(true) {
            System.out.println("Choose a job for the person:");
            for (int i = 0; i < Jobs.values().length; i++) {
                System.out.print(i + ": ");
                System.out.println(Jobs.values()[i].getDescription());
            }
            job = Integer.parseInt(scan.nextLine());
            if(job > -1 && job < 7) {
                break;
            }
            System.out.println("Input not valid");
        }

        Person person = new Person(personName, Jobs.values()[job], bank);

        while(true) {

            boolean leave = false;

            int opt = 0;
            while(true) {
                System.out.println("1. Work 2. Deposit 3. Withdraw 4. Payment 5. Log 6. My details 7. Exit");
                System.out.println("Option: ");
                opt = Integer.parseInt(scan.nextLine());
                if(opt > 0 && opt < 8) {
                    break;
                }
                System.out.println("Input not valid");
            }

            switch(opt) {
                case 1:
                    person.work();
                    break;
                case 2:
                    System.out.println("Deposit amount:");
                    float depositAmount = Float.parseFloat(scan.nextLine());
                    person.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Withdraw amount:");
                    float withdrawAmount = Float.parseFloat(scan.nextLine());
                    person.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Payment reference");
                    String paymentReference = scan.nextLine();
                    System.out.println("Payment amount:");
                    float paymentAmount = Float.parseFloat(scan.nextLine());
                    person.makeBankPayment(paymentAmount);
                    break;
                case 5:
                    person.getBankLog();
                    break;
                case 6:
                    System.out.println("Name: " + person.getName());
                    System.out.println("Job: " + person.getJob());
                    System.out.println("Pocket: " + person.getPocket());
                    System.out.println("Bank balance: " + person.getBankBalance());
                    break;
                default:
                    leave = true;
                    break;
            }

            if(leave) {
                break;
            }
        }

    }

}
