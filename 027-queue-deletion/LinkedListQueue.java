import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {
  private Node head;
  private Node tail;
  private int N = 0;

  private class Node {
    Item item;
    Node next;
  }

  public void enqueue(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) { head = tail = newNode; }
    else {
      tail.next = newNode;
      tail = newNode;
    }

    N++;
  }

  public Item dequeue() {
    if (isEmpty()) { return null; }

    Node oldHead = head;
    head = head.next;
    N--;

    return oldHead.item;
  }

  public boolean isEmpty() { 
    return N == 0;
  }

  public int size() {
    return N;
  }

  public Item delete(int k) {
    Node prev = head;
    Node toDelete = head;

    for (int i = 0; i < k; i++) { 
      prev = toDelete; 
      toDelete = toDelete.next;
    }

    prev.next = toDelete.next;

    return toDelete.item;
  }

  public LinkedListQueueIterator iterator() {
    return new LinkedListQueueIterator();
  }

  private class LinkedListQueueIterator implements Iterator<Item> {
    Node next = head;
    int L = 0;

    public boolean hasNext() {
      return L < N-1;
    }

    public Item next() { 
      Node oldNext = next;

      if (next.next != null) { next = next.next; }
      L++;

      return oldNext.item;
    }
  }
}
