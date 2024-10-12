package Range;

import java.util.Iterator;
import java.util.function.Consumer;


// Range iterator class to implement Iterator, create range iterator constructor,
// plus override super class methos hasNext, next and remove.
public class RangeIterator implements Iterator<Integer> {

    int initial;
    int last;
    private Node<Integer> head;
    private Node<Integer> currentNode;

// Constructor method to populate new nodes with data and next pointer
    public RangeIterator(int initial, int last) {

        this.initial = initial;
        this.last = last;

        this.head = new Node<Integer>(null, null);
        this.head.setNext(new Node<Integer>(null, null));
        Node<Integer> node = this.head.getNext();

        for (int i = initial; i < last + 1; i++) {

            node.setData(i);
            node.setNext(i > last ? null : new Node<Integer>(null, null));
            node = node.getNext();
        }

        this.currentNode = head;

        System.out.println(currentNode.getNext().getData());

    }
// Boolean method to check if current node has a next pointer
    @Override
    public boolean hasNext() {
        if (currentNode.getNext().getData() == null) {
            this.currentNode = this.head;
            return false;
        }
        return true;
    }
// Method to return the data in the current node
    @Override
    public Integer next() {
        this.currentNode = currentNode.getNext();
        int result = currentNode.getData();
        return result;

    }
// Method to remove nodes from our list, i.e. changing the reference from the previous node
    @Override
    public void remove() {


        Node<Integer> previousNode = getPreviousNode(this.currentNode);


        previousNode.setNext(this.currentNode.getNext());

    }
// Method to return the previous node, to use in the remove method
    public Node<Integer> getPreviousNode(Node<Integer> target) {

        Node<Integer> node = head.getNext();

        System.out.println("Looking for ... " + target.getData());

        while (node.getNext() != target) {
            node = node.getNext();
        }

        System.out.println("Accessing node: " + node.getData() + " to change its reference");

        return node;

    }
}
