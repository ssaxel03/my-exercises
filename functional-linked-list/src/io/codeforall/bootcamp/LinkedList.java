package io.codeforall.bootcamp;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A simple Linked List container implementation
 */
public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        head = new Node(null);
    }

    /**
     * Obtain the number of data elements on the list
     *
     * @return
     */
    public int size() {
        return length;
    }

    /**
     * Adds a data element to the container
     *
     * @param data the element to add
     */
    public void add(T data) {

        Node node = new Node(data);
        Node iterator = head;

        // Advance to the end of the list
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(node);
        length++;
    }

    /**
     * Returns the index of the first occurrence of the data element in the list
     *
     * @param data the element to search for
     * @return the index of the element, or -1 if the list does not contain the element
     */
    public int indexOf(T data) {

        int index = 0;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getData().equals(data)) {
                return index;
            }

            iterator = iterator.getNext();
            index++;
        }

        // Data was not found
        return -1;
    }

    /**
     * Returns the data element at the specified index
     *
     * @param index index of the the element to return
     * @return the returned element or null if not found
     */
    public T get(int index) {

        Node iterator = head.getNext();

        while (iterator != null) {
            if (index == 0) {
                return iterator.getData();
            }

            iterator = iterator.getNext();
            index--;
        }

        return null;
    }

    /**
     * Removes the first occurrence of the data element from the list
     *
     * @param data the element to remove
     * @return true if the list contains the element
     */
    public boolean remove(T data) {

        Node previous = head;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getData().equals(data)) {
                previous.setNext(iterator.getNext());
                length--;
                return true;
            }

            previous = iterator;
            iterator = iterator.getNext();

        }

        return false;
    }

    /**
     * Applies a transformation to each data element of the list and pushes the transformed elements to a new list which is then returned
     *
     * @param mapper the Function describing the transformation to be performed on the data
     * @param <R>    the type of the return value
     * @return a new list populated by the elements resultant from the mapping of the original list
     */
    public <R> LinkedList<R> map(Function<T, R> mapper) {

        LinkedList<R> returnList = new LinkedList();

        for (T element : this) {
            returnList.add(mapper.apply(element));
        }

        return returnList;
    }

    /**
     * Applies a filter to each element of the list and pushes the selected elements to a new list which is then returned
     *
     * @param predicate the Predicate describing the condition necessary for an element to be selected by the filter
     * @return new list populated with elements selected by the filter
     */
    public LinkedList<T> filter(Predicate<T> predicate) {

        LinkedList<T> returnList = new LinkedList<>();

        for (T element : this) {
            if (predicate.test(element)) {
                returnList.add(element);
            }
        }

        return returnList;

    }

    /**
     * Reduces the list to a single value which is then returned
     *
     * @param reducer     reducer function
     * @param accumulator parameter passed to aggregate the result of applying reducer function
     * @return value resultant from the reduction of the list by applying the reducer function
     */
    public T reduce(BinaryOperator<T> reducer, T accumulator) {

        for (T element : this) {
            accumulator = reducer.apply(accumulator, element);
        }

        return accumulator;

    }

    /**
     * Checks if any data element in the list matches the data object passed as argument
     *
     * @param predicate condition to be fulfilled in order for element to match
     * @return true if any element of list matches the predicate
     */
    public boolean anyMatch(Predicate<T> predicate) {

        for (T element : this) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Checks if all data elements in the list match the condition on the predicate passed as argument
     *
     * @param predicate condition to be fulfilled in order for element to match
     * @return true if all elements in list match
     */
    public boolean allMatch(Predicate<T> predicate) {

        for (T element : this) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("LinkedList{ ");

        for (T element : this) {
            builder.append(" ")
                    .append(element)
                    .append(" ,");
        }

        builder.append("}");

        return builder.toString();
    }

    private class ListIterator implements Iterator<T> {

        Node iterator = head;

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public T next() {
            iterator = iterator.getNext();
            return iterator.getData();
        }

        @Override
        public void remove() {
            LinkedList.this.remove(iterator.getData());
        }
    }

    /**
     * Linked List Node, used internally by the LinkedList class only
     */
    private class Node {

        /**
         * Reference to the next Node in the list
         */
        private Node next;

        /**
         * Reference to the data
         */
        private T data;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
