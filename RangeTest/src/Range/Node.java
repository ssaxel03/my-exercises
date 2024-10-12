package Range;

// Class to create nodes with the values from Range r
class Node<Integer> {
    Integer data;
    Node<Integer> next;

    // Class constructor to give data and next pointer
    public Node(Integer data, Node<Integer> next)
    {
        this.data = data;
        this.next = next;
    }

    // Setter and getter methods for Data and Next Pointer
    public void setData(Integer data)
    {
        this.data = data;
    }

    public void setNext(Node<Integer> next)
    {
        this.next = next;
    }

    public Integer getData()
    {
        return data;
    }

    public Node<Integer> getNext()
    {
        return next;
    }
}
