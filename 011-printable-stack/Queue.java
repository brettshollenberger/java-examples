import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node head;
  private Node tail;
  private int length;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int size() {
    return length;
  }

  // If item is first, it becomes the head
  // Else, tail item's next becomes the new node
  // Item always becomes the tail
  // Length always increments
  //
  public void enqueue(Item item) {
    Node node = new Node();
    node.item = item;

    if (isEmpty()) {
      head = node;
    } else {
      tail.next = node;
    }

    tail = node;
    length++;
  }

  public Item dequeue() {
    if (!isEmpty()) {
      Node node = head;
      head = node.next;
      length--;
      return node.item;
    } else {
      return null;
    }
  }

  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    private Node nextNode = head;
    private int i = length;

    public boolean hasNext() {
      return i >= 0;
    }

    public Item next() {
      Node node = nextNode;
      nextNode = node.next;
      i--;
      return node.item;
    }

    public void remove() {}
  }
}
