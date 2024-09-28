package io.codeforall.bootcamp.exercise;

public class Ai {

    private String creationDate;
    private String name;

    public Ai(String name, String creationDate) {
        this.creationDate = creationDate;
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] doubleArray(int[] array) {

        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i] * 2;
        }

        return newArray;
    }

    public int factorialIterative(int input) {

        int result = 1;

        for (int i = input; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public int factorialRecursive(int input) {

        if(input == 0) {
            return 1;
        }

        return input * factorialRecursive(input - 1);
    }

    public String palindromeReplace(String str) {

        String[] result = str.split(" ");


        for (int i = 0; i < result.length; i++) {
            if (isPalindrome(result[i])) {
                result[i] = "palindrome";
            }
        }

        return String.join(" ", result);

    }

    private boolean isPalindrome(String str) {

        StringBuilder reverseStr = new StringBuilder();
        str = str.toLowerCase();

        for (int i = str.length() - 1; i >= 0 ; i--) {
            reverseStr.append(str.charAt(i));
        }

        return str.contentEquals(reverseStr);
    }

    public String emailValidator() {
        return "^(.+)@(.+)$";
    }

}

