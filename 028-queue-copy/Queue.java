import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node head;
  private Node tail;
  private int N = 0;

  private class Node {
    Node next;
    Item item;
  }

  public boolean isEmpty() { 
    return N == 0;
  }

  public int size() {
    return N;
  }

  public Queue<Item> copy() {
    Queue<Item> clone = new Queue<Item>();

    for (Item item : this) {
      clone.enqueue(item);
    }

    return clone;
  }

  public void enqueue(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) { head = tail = newNode; }
    else {
      tail.next = newNode;
      tail      = newNode;
    }

    N++;
  }

  public Item dequeue() {
    if (isEmpty()) { return null; }

    Node oldHead = head;

    if (head.next != null) { head = head.next; }

    N--;

    return oldHead.item;
  }

  public QueueIterator iterator() { 
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    Node next = head;
    int Q = N;

    public boolean hasNext() {
      return Q > 0;
    }

    public Item next() {
      Node oldNext = next;

      if (next.next != null) { next = next.next; }
      Q--;

      return oldNext.item;
    }
  }
}
