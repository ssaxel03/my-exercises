package io.codeforall.fanstatics;

public class Machine {

        BiOperation<Integer> sum = (num1, num2) -> num1 + num2;
        BiOperation<Integer> subtract = (num1, num2) -> num1 - num2;
        BiOperation<Integer> multiply = (num1, num2) -> num1 * num2;
        BiOperation<Float> divide = (num1, num2) -> num1 / num2;

        MonoOperation<Integer> square = (num1) -> num1 * num1;
        MonoOperation<Float> sqrt = (num1) -> (float) Math.sqrt(num1);

        BiOperation<String> concat = (str1, str2) -> str1.concat(str2);
        MonoOperation<String> upperCase = (str1) -> str1.toUpperCase();
        MonoOperation<String> lowerCase = (str1) -> str1.toLowerCase();
}
