package io.codeforall.bootcamp;

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedListTest test = new LinkedListTest();
        test.assertCondition("Add data to the list", test.testAdd());
        test.assertCondition("Index data from the list", test.testIndex());
        test.assertCondition("Get data from the list", test.testGet());
        test.assertCondition("Remove data from the list", test.testRemove());

    }

    /**
     * Tests insertion of data objects into the list
     *
     * @return true if all tests passed
     */
    public boolean testAdd() {

        // Preparation
        LinkedList list = new LinkedList();

        // Empty list should contain zero elements
        if (list.size() != 0) {
            return false;
        }

        // List with one element should have size of one
        list.add(new Integer(1));
        if (list.size() != 1) {
            return false;
        }

        // List with two elements should have size of two
        list.add(new Integer(2));
        if (list.size() != 2) {
            return false;
        }

        // List with three elements should have size of three
        list.add(new Integer(3));
        if (list.size() != 3) {
            return false;
        }

        return true;

    }

    /**
     * Tests obtaining the index of data objects from the list
     *
     * @return true if all tests passed
     */
    public boolean testIndex() {

        // Preparation
        LinkedList list = new LinkedList();
        Object data1 = new Integer(1);
        Object data2 = new Integer(2);
        Object data3 = new Integer(3);
        Object data4 = new Integer(4);

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

        if (list.indexOf(data4) != -1) {
            return false;
        }

        return true;
    }

    /**
     * Tests getting data objects from the list
     *
     * @return true if all tests passed
     */
    public boolean testGet() {

        // Preparation
        LinkedList list = new LinkedList();
        Object data1 = new Integer(1);
        Object data2 = new Integer(2);
        Object data3 = new Integer(3);

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

        if (list.get(9) != null) {
            return false;
        }

        return true;

    }

    /**
     * Tests removing data objects from the list
     *
     * @return true if all tests passed
     */
    public boolean testRemove() {

        // Preparation
        LinkedList list = new LinkedList();
        Object data1 = new Integer(1);
        Object data2 = new Integer(2);
        Object data3 = new Integer(3);
        Object data4 = new Integer(4);

        // Test removal with empty list
        if (list.remove(data1)) {
            System.out.println("1");
            return false;
        }
        ;

        // Test removal from list with one element
        list.add(data1);

        if (list.remove(data2)) {
            System.out.println("2");
            return false;
        }

        if (!list.remove(data1)) {
            System.out.println("3");
            return false;
        }

        if (list.size() != 0) {
            System.out.println("4");
            return false;
        }

        // Test removal from list with two elements
        list.add(data1);
        list.add(data2);

        if (list.remove(data3)) {
            System.out.println("5");
            return false;
        }

        if (!list.remove(data1)) {
            System.out.println("6");
            return false;
        }

        if (list.size() != 1) {
            System.out.println("7");
            return false;
        }

        list.add(data1);
        if (!list.remove(data1)) {
            System.out.println("9");
            return false;
        }

        if (!list.remove(data2)) {
            System.out.println("9");
            return false;
        }

        if (list.size() != 0) {
            System.out.println("10");
            return false;
        }

        // Test removal from list with three elements
        list.add(data1);
        list.add(data2);
        list.add(data3);

        if (list.remove(data4)) {
            System.out.println("11");
            return false;
        }

        if (!list.remove(data2)) {
            System.out.println("12");
            return false;
        }

        if (list.size() != 2) {
            System.out.println("13");
            return false;
        }

        if (list.indexOf(data1) != 0) {
            System.out.println("14");
            return false;
        }

        if (list.indexOf(data3) != 1) {
            System.out.println("15");
            return false;
        }

        if (!list.remove(data3)) {
            System.out.println("16");
            return false;
        }

        if (list.size() != 1) {
            System.out.println("17");
            return false;
        }

        return true;
    }

    private void assertCondition(String test, boolean result) {

        System.out.println(test + ": " + (result ? "OK" : "FAIL"));

    }

}
