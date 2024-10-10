package io.codeforall.bootcamp;

public class LinkedList {

    private Node head;
    private int length;

    public LinkedList() {
        this.head = new Node(null);
        this.length = 0;
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        if(length <= 0) {
            return null;
        }

        Node node = head.getNext();

       for (int i = 0; i < length; i++) {
           if(i == index) {
               return node.getData();
           }
           node = node.getNext();
        }

        return null;
        //throw new UnsupportedOperationException();
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        if(length == 0) {
            return -1;
        }

        Node node = this.head.getNext();

        if(node.getData() == null) {
            return -1;
        }

        int index = 0;
        while (!node.getData().equals(data)){
            node = node.getNext();
            if(node == null) {
                return -1;
            }
            index++;
        }
        return index;

        //throw new UnsupportedOperationException();
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

       if(length == 0) {
           return false;
       }

       Node node = head.getNext();

       for(int i = 0; i < length; i++) {
           if(node.getData().equals(data)) {
               if(i == 0) {
                   head.setNext(this.getNode(1));
                   length--;
                   return true;
               }
               if(i == length - 1) {
                   this.getNode(i - 1).setNext(null);
                   length--;
                   return true;
               }
                this.getNode(i - 1).setNext(getNode(i + 1));
               length--;
               return true;
           }
           node = node.getNext();
       }

        return false;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node getNode(int index) {
        Node node = head.getNext();
        for (int i = 0; i < length; i++) {
            if(i == index) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void tostring() {
        for (int i = 0; i < length ; i++) {
            System.out.println(this.get(i));
        }
    }

}
