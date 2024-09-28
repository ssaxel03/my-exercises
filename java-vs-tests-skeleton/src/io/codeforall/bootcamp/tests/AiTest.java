package io.codeforall.bootcamp.tests;

import io.codeforall.bootcamp.exercise.Ai;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AiTest {

    public static void main(String[] args) {

        assertCondition("Properties", createProperties());
        assertCondition("Constructor", createConstructor());
        assertCondition("Get methods", createGet());
        assertCondition("Set methods", createSet());
        assertCondition("Duplicate Array", createMethodArray());
        assertCondition("Palindrome", palindromeCheck());
        assertCondition("Factorial Iterative", factorialIterativeCheck());
        assertCondition("Factorial Recursive", factorialRecursiveCheck());
        assertCondition("Email Validator", emailValidation());
    }

    private static TestResult createProperties() {

        Field[] fields = Ai.class.getDeclaredFields();

        // Tests if the properties were created
        if (fields.length <= 0) {
            return new TestResult(false, "You should create two properties");
        }

        // Tests if the properties of the class have the correct name
        long filteredFieldsByName = Arrays.stream(fields)
                .filter(field -> field.getName().equals("name") || field.getName().equals("creationDate"))
                .count();

        if (filteredFieldsByName <= 0) {
            return new TestResult(false, "You should create two properties called 'name' and 'creationTime'");
        }

        // Tests if both properties are Strings
        long filteredFieldsByType = Arrays.stream(fields)
                .filter(field -> field.getType().equals(String.class))
                .count();

        if (filteredFieldsByType < 2) {
            return new TestResult(false, "You should create two Strings");
        }

        return new TestResult(true, null);
    }

    private static TestResult createConstructor() {

        try {
            // Tests if the default constructor is still active
            Ai.class.getConstructor();
            return new TestResult(false, "You didn't declare a constructor");

        } catch (NoSuchMethodException e) {
            // If the constructor is not default we should test if the properties are correctly set
            return constructorSetsProperties();
        }
    }

    private static TestResult constructorSetsProperties() {

        // Tests if the constructor sets the properties correctly
        String name = "I am here for you";
        String creationDate = "21/12/2012";

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        try {

            // Get the properties declared in the class Ai
            Field nameField = Ai.class.getDeclaredField("name");
            Field creationDateField = Ai.class.getDeclaredField("creationDate");

            // Set those properties accessible even if private
            nameField.setAccessible(true);
            creationDateField.setAccessible(true);

            // Get the values from those properties in the object Ai ai
            String nValue = (String) nameField.get(ai);
            String cDateValue = (String) creationDateField.get(ai);

            // Checks if the name value is not the same
            if (!(nValue.equals(name) || nValue.equals(creationDate))) {
                return new TestResult(false, "name property not properly set");
            }

            // Checks if the creation date value is not the same
            if (!(cDateValue.equals(creationDate) || cDateValue.equals(name))) {
                return new TestResult(false, "creationDate property not properly set");
            }

            // If it's all the same, it passes the test and the properties did set
            return new TestResult(true, null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            return new TestResult(false, "The properties were not created");
        }
    }

    private static TestResult createGet() {

        // Tests if method exists with the correct name
        TestResult creationDateGetExists = testIfMethodExists("getCreationDate");
        TestResult nameGetExists = testIfMethodExists("getName");

        if (!creationDateGetExists.pass) {
            return creationDateGetExists;
        }

        if (!nameGetExists.pass) {
            return nameGetExists;
        }

        String name = "Can you get";
        String creationDate = "the answer you're looking for?";

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests if getters functionality
        try {

            Method getName = getMethod("getName", null);
            Method getCreationDate = getMethod("getCreationDate", null);

            // Get the properties declared in the class Ai
            Field nameField = Ai.class.getDeclaredField("name");
            Field creationDateField = Ai.class.getDeclaredField("creationDate");

            // Set those properties accessible even if private
            nameField.setAccessible(true);
            creationDateField.setAccessible(true);

            // Get the values from those properties in the object Ai ai
            String nValue = (String) nameField.get(ai);
            String cDateValue = (String) creationDateField.get(ai);

            if (!getName.invoke(ai).equals(nValue)) {
                return new TestResult(false, "Your getName is not returning the right value");
            }

            if (!getCreationDate.invoke(ai).equals(cDateValue)) {
                return new TestResult(false, "Your getCreationTime is not returning the right value");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");

        } catch (NoSuchFieldException e) {
            return new TestResult(false, "The fields are not properly declared");
        }

        return new TestResult(true, null);
    }

    private static TestResult createSet() {

        // Tests if method exists with the correct name
        TestResult creationDateSetExists = testIfMethodExists("setCreationDate");
        TestResult nameSetExists = testIfMethodExists("setName");

        if (!creationDateSetExists.pass) {
            return creationDateSetExists;
        }

        if (!nameSetExists.pass) {
            return nameSetExists;
        }

        String name = "name test";
        String creationDate = "creation date test";

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests setters functionality
        try {

            // Get Methods necessary for the tests
            Method setName = getMethod("setName", String.class);
            Method setCreationDate = getMethod("setCreationDate", String.class);
            Method getName = getMethod("getName", null);
            Method getCreationDate = getMethod("getCreationDate", null);

            Object[] argsSet = {"afterSet"};

            setName.invoke(ai, argsSet);
            setCreationDate.invoke(ai, argsSet);


            // If the value of the property name didn't change
            if (getName.invoke(ai).equals(name)) {
                return new TestResult(false, "setName is not setting the value properly");
            }

            // If the value of the property creationDate didn't change
            if (getCreationDate.invoke(ai).equals(creationDate)) {

                return new TestResult(false, "setCreationDate is not setting the value properly");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");
        }

        return new TestResult(true, null);
    }

    private static TestResult createMethodArray() {

        // Tests if method exists with the correct name
        TestResult methodExist = testIfMethodExists("doubleArray");

        if (!methodExist.pass) {
            return methodExist;
        }

        String name = "test";
        String creationDate = "01/01/2001";
        int[] arr = {5, 6, 10, 32};
        int[] doubleArr = Arrays.stream(arr).map(elem -> elem * 2).toArray();

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests the method functionality
        try {

            // Get the method and invoke it
            Object resultObj = getMethod("doubleArray", int[].class).invoke(ai, arr);
            int[] result = null;

            if (resultObj instanceof int[]) {
                result = (int[]) resultObj;
            }

            // Tests if the original array is manipulated
            if (result == arr) {
                return new TestResult(false, "You should not return the same array");
            }

            // Tests if the return is correct
            if (!Arrays.equals(doubleArr, result)) {
                return new TestResult(false, "The return should contain the content of the array times two");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");
        }

        return new TestResult(true, null);
    }

    private static TestResult palindromeCheck() {
        // Tests if method exists with the correct name
        TestResult methodExist = testIfMethodExists("palindromeReplace");

        if (!methodExist.pass) {
            return methodExist;
        }

        // Tests the method functionality
        String name = "TestNamePalindrome";
        String creationDate = "01/01/2001";
        String palindromeTestPass = "hello, I am testing nozkkzon abba AbBa ABBA";
        String palindromeExpectedResult = "hello, palindrome am testing palindrome palindrome palindrome palindrome";

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests the method functionality
        try {

            String resultPass = (String) getMethod("palindromeReplace", String.class).invoke(ai, palindromeTestPass);

            // Test method return
            if (!resultPass.equals(palindromeExpectedResult)) {
                return new TestResult(false, "not returning the correct string");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");
        }

        return new TestResult(true, null);
    }

    private static TestResult factorialIterativeCheck() {

        // Tests if method exists with the correct name
        TestResult iterativeMethodExist = testIfMethodExists("factorialIterative");

        if (!iterativeMethodExist.pass) {
            return iterativeMethodExist;
        }

        String name = "TestNameFactorialIt";
        String creationDate = "01/01/2001";
        int testValue = 5;
        int expectedResult = 120;

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests the method functionality
        try {

            int resultIterative = (int) getMethod("factorialIterative", int.class).invoke(ai, testValue);

            // Test method return
            if (resultIterative != expectedResult) {
                return new TestResult(false, "Iterative: not calculating the factorial correctly");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");
        }

        return new TestResult(true, null);
    }

    private static TestResult factorialRecursiveCheck() {

        // Tests if method exists with the correct name
        TestResult recursiveMethodExist = testIfMethodExists("factorialRecursive");

        if (!recursiveMethodExist.pass) {
            return recursiveMethodExist;
        }

        String name = "TestNameFactorialRc";
        String creationDate = "01/01/2001";
        int testValue = 5;
        int expectedResult = 120;

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests the method functionality
        try {

            int resultRecursive = (int) getMethod("factorialRecursive", int.class).invoke(ai, testValue);

            // Test method return
            if (resultRecursive != expectedResult) {
                return new TestResult(false, "Recursive: not calculating the factorial correctly");
            }

        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");
        }

        return new TestResult(true, null);
    }

    private static TestResult emailValidation() {

        // Tests if method exists with the correct name
        TestResult emailValidatorExists = testIfMethodExists("emailValidator");

        if (!emailValidatorExists.pass) {
            return emailValidatorExists;
        }

        String name = "John Doe.";
        String creationDate = "01/01/2001";

        Optional<Ai> instance = createInstance(name, creationDate);

        // Checks if the instance is created
        if (!instance.isPresent()) {
            return new TestResult(false, "Constructor not working");
        }

        Ai ai = instance.get();

        // Tests the method functionality
        try {

            Object resultObj = getMethod("emailValidator", null).invoke(ai);
            String regexExpression = null;

            if (resultObj instanceof String) {
                regexExpression = (String) resultObj;
            }

            if(regexExpression == null){
                return new TestResult(false, "The return of your method is wrong");
            }

            List<String> validEmails = new ArrayList<>();
            validEmails.add("user@studio.com");
            validEmails.add("user@stud.io");
            validEmails.add("user1@studio.com");
            validEmails.add("user.name@studio.com");
            validEmails.add("user#@studio.io");
            validEmails.add("user@studiocom");


            List<String> invalidEmails = new ArrayList<>();
            // Invalid emails
            invalidEmails.add("user#studio.com");
            invalidEmails.add("@studio.com");
            invalidEmails.add("studio");

            Pattern pattern = Pattern.compile(regexExpression);
            long validCount = validEmails.stream().filter(email -> !pattern.matcher(email).matches()).count();
            long invalidCount = invalidEmails.stream().filter(email -> pattern.matcher(email).matches()).count();

            if(validCount > 0 ) {
                return new TestResult(false,"Your regEX expression is not correct");
            }

            if(invalidCount > 0 ) {
                return new TestResult(false,"Your regEX expression is not correct");
            }
        } catch (NoSuchMethodException e) {
            return new TestResult(false, "Method signature is wrong");

        } catch (InvocationTargetException e) {
            return new TestResult(false, e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            return new TestResult(false, "Can't access the method");

        } catch(PatternSyntaxException e) {
            return new TestResult(false, "Your regex pattern is invalid");
        }

        return new TestResult(true,null);
    }

    // Utility methods and Class for testing
    private static TestResult testIfMethodExists(String methodName) {

        Method[] methods = Ai.class.getDeclaredMethods();

        long filteredMethodByName = Arrays.stream(methods)
                .filter(method -> method.getName().equals(methodName))
                .count();

        // Tests if the method exists with the correct name
        if (filteredMethodByName <= 0) {
            return new TestResult(false, "You should declare a " + methodName + " method");
        }

        return new TestResult(true, null);
    }

    private static Optional<Ai> createInstance(String name, String creationDate) {

        try {

            Constructor<?> constructor = Ai.class.getConstructor(String.class, String.class);
            return Optional.of((Ai) constructor.newInstance(name, creationDate));

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            return Optional.empty();
        }

    }

    private static Method getMethod(String methodName, Class<?> parameters) throws NoSuchMethodException {
        return parameters == null ? Ai.class.getMethod(methodName) : Ai.class.getMethod(methodName, parameters);
    }

    private static void assertCondition(String test, TestResult result) {

        System.out.println(test + ": " + (result.pass ? "OK" : "FAIL"));
        if (!result.pass) {
            System.out.println(" => " + result.message);
        }
    }

    private static class TestResult {

        public boolean pass = true;
        public String message;

        public TestResult(boolean pass, String message) {
            this.pass = pass;
            this.message = message;
        }
    }
}
