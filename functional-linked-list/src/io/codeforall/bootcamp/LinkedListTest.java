package io.codeforall.bootcamp;

import java.util.function.*;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedListTest test = new LinkedListTest();
        test.assertCondition("Add data to the list", test.testAdd());
        test.assertCondition("Index data from the list", test.testIndex());
        test.assertCondition("Get data from the list", test.testGet());
        test.assertCondition("Remove data from the list", test.testRemove());
        System.out.println();
        test.assertCondition("Apply transformation to data in list and return a new list", test.testMap());
        test.assertCondition("Filter data in list and return a new list", test.testFilter());
        test.assertCondition("Reduce data on the list to a single element", test.testReduce());
        test.assertCondition("Check if data is present in list", test.testAnyMatch());
        test.assertCondition("Check if all data in list conforms to condition", test.testAllMatch());
        test.assertCondition("Chain methods together to perform complex transformation", test.testMethodChaining());
    }

    /**
     * Tests insertion of data objects into the list
     *
     * @return true if all tests passed
     */
    private boolean testAdd() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        // List with one element should have size of one
        list.add(1);
        if (list.size() != 1) {
            return false;
        }

        // List with two elements should have size of two
        list.add(2);
        if (list.size() != 2) {
            return false;
        }

        // List with three elements should have size of three
        list.add(3);

        return list.size() == 3;

    }

    /**
     * Tests obtaining the index of data objects from the list
     *
     * @return true if all tests passed
     */
    private boolean testIndex() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();
        Integer data1 = 1;
        Integer data2 = 2;
        Integer data3 = 3;
        Integer data4 = 4;

        // Tests with empty list
        if (list.indexOf(data1) != -1) {
            return false;
        }

        // Tests with one element
        list.add(data1);
        if (list.indexOf(data1) != 0) {
            return false;
        }

        if (list.indexOf(data2) != -1) {
            return false;
        }

        // Tests with two elements
        list.add(data2);
        if (list.indexOf(data1) != 0) {
            return false;
        }

        if (list.indexOf(data2) != 1) {
            return false;
        }

        if (list.indexOf(data3) != -1) {
            return false;
        }

        // Tests with three elements
        list.add(data3);
        if (list.indexOf(data1) != 0) {
            return false;
        }

        if (list.indexOf(data2) != 1) {
            return false;
        }

        if (list.indexOf(data3) != 2) {
            return false;
        }

        return list.indexOf(data4) == -1;
    }

    /**
     * Tests getting data objects from the list
     *
     * @return true if all tests passed
     */
    private boolean testGet() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();
        Integer data1 = 1;
        Integer data2 = 2;
        Integer data3 = 3;

        // Tests with empty list
        if (list.get(0) != null) {
            return false;
        }

        if (list.get(1) != null) {
            return false;
        }

        if (list.get(9) != null) {
            return false;
        }

        // Tests with one element
        list.add(data1);
        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (list.get(1) != null) {
            return false;
        }

        if (list.get(9) != null) {
            return false;
        }

        // Tests with two elements
        list.add(data2);
        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (!data2.equals(list.get(1))) {
            return false;
        }

        if (list.get(2) != null) {
            return false;
        }

        if (list.get(9) != null) {
            return false;
        }

        // Tests with three elements
        list.add(data3);
        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (!data2.equals(list.get(1))) {
            return false;
        }

        if (!data3.equals(list.get(2))) {
            return false;
        }

        if (list.get(3) != null) {
            return false;
        }

        return list.get(9) == null;

    }

    /**
     * Tests removing data objects from the list
     *
     * @return true if all tests passed
     */
    private boolean testRemove() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();
        Integer data1 = 1;
        Integer data2 = 2;
        Integer data3 = 3;
        Integer data4 = 4;

        // Test removal with empty list
        if (list.remove(data1)) {
            return false;
        }


        // Test removal from list with one element
        list.add(data1);

        if (list.remove(data2)) {
            return false;
        }

        if (!list.remove(data1)) {
            return false;
        }

        if (list.size() != 0) {
            return false;
        }

        // Test removal from list with two elements
        list.add(data1);
        list.add(data2);

        if (list.remove(data3)) {
            return false;
        }

        if (!list.remove(data1)) {
            return false;
        }

        if (list.size() != 1) {
            return false;
        }

        list.add(data1);
        if (!list.remove(data1)) {
            return false;
        }

        if (!list.remove(data2)) {
            return false;
        }

        if (list.size() != 0) {
            return false;
        }

        // Test removal from list with three elements
        list.add(data1);
        list.add(data2);
        list.add(data3);

        if (list.remove(data4)) {
            return false;
        }

        if (!list.remove(data2)) {
            return false;
        }

        if (list.size() != 2) {
            return false;
        }

        if (list.indexOf(data1) != 0) {
            return false;
        }

        if (list.indexOf(data3) != 1) {
            return false;
        }

        if (!list.remove(data3)) {
            return false;
        }

        return list.size() == 1;
    }


    /**
     * Tests mapping transformations of data objects in list to a new list
     *
     * @return true if tests pass
     */
    private boolean testMap() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        if (list.size() != 6) {
            return false;
        }

        Function<Integer, Integer> doubleInt = integer -> integer * 2;

        LinkedList<Integer> newList = list.map(doubleInt);

        if (list.size() != newList.size()) {
            return false;
        }

        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i) != list.get(i) * 2) {
                return false;
            }
        }

        return true;

    }

    /**
     * Tests filtering of data objects in list to a new list
     *
     * @return true if tests pass
     */
    private boolean testFilter() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        if (list.size() != 6) {
            return false;
        }

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> isOdd = integer -> !isEven.test(integer);

        LinkedList<Integer> evenList = list.filter(isEven);
        LinkedList<Integer> oddList = list.filter(isOdd);

        if (evenList.size() != 3 || oddList.size() != 3) {
            return false;
        }

        for (Integer number : evenList) {
            if (number % 2 != 0) {
                return false;
            }
        }

        for (Integer number : oddList) {
            if (number % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Tests reducing of data objects in list to a single value
     *
     * @return true if tests pass
     */
    private boolean testReduce() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        // List with one element should have size of one
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        if (list.size() != 6) {
            return false;
        }

        BinaryOperator<Integer> sum = (acc, integer) -> integer + acc;
        Integer total = list.reduce(sum, 0);

        if (total != 21) {
            return false;
        }

        LinkedList<String> words = new LinkedList<>();

        words.add("Code");
        words.add("Cadet");

        BinaryOperator<String> stringReducer = (text, word) -> text + " " + word;
        String phrase = words.reduce(stringReducer, "Hello");

        return phrase.equals("Hello Code Cadet");
    }

    /**
     * Tests if a data object in list matches a specific data object
     *
     * @return true if tests pass
     */
    private boolean testAnyMatch() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        list.add(2);
        list.add(4);
        list.add(6);

        if (list.size() != 3) {
            return false;
        }

        Predicate<Integer> isOdd = number -> number % 2 != 0;

        return list.anyMatch(num -> num % 6 == 0) && !list.anyMatch(isOdd);
    }

    /**
     * Tests if all data objects in list match a certain condition
     *
     * @return true if tests pass
     */
    private boolean testAllMatch() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        // List with one element should have size of one
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);

        if (list.size() != 6) {
            return false;
        }

        Predicate<Integer> isEven = integer -> integer % 2 == 0;

        return list.allMatch(isEven);
    }

    /**
     * Tests chaining of transformations to data objects in list
     *
     * @return true if tests pass
     */
    private boolean testMethodChaining() {

        // Preparation
        LinkedList<Integer> list = new LinkedList<>();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        // List with one element should have size of one
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        if (list.size() != 6) {
            return false;
        }

        // after doubling the value of each element on the list calculate the average of of all even elements which are not divisible by 3

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> isDivisibleByThree = integer -> integer % 3 == 0;
        BinaryOperator<Integer> sum = (element, accumulator) -> element + accumulator;

        LinkedList<Integer> filteredList = list.map(integer -> integer * 2)
                .filter(isEven.and(isDivisibleByThree.negate()));

        int calculated = filteredList
                .reduce(sum, 0) / filteredList.size();

        return calculated == 6;
    }


    private void assertCondition(String test, boolean result) {

        System.out.println(test + ": " + (result ? "OK" : "FAIL"));

    }
}
