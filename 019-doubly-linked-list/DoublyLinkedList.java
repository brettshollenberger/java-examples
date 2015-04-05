import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N = 0;

  private class Node {
    Item item;
    Node next;
    Node prev;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) first = last = newNode;
    else {
      last.next = newNode;
      newNode.prev = last;
      last = newNode;
    }

    N++;
  }

  public Item pop() {
    if (isEmpty()) return null;

    Node oldLast = last;
    last.prev.next = null;
    last = last.prev;
    N--;

    return oldLast.item;
  }

  public void unshift(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) first = last = newNode;
    else {
      first.prev   = newNode;
      newNode.next = first;
      first = newNode;
    }

    N++;
  }

  public Item shift() {
    if (isEmpty()) return null;

    Node oldFirst   = first;
    first.next.prev = null;
    first = first.next;
    N--;

    return oldFirst.item;
  }

  public Item remove(int k) {
    int j     = 0;
    Node node = first;

    for (j = 0; j != k; j++) {
      if (node.next == null) return null;

      node = node.next;
    }

    if (node.next != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    N--;

    return node.item;
  }

  public boolean find(Item item) {
    for (Item i: this) {
      if (i == item) return true;
    }

    return false;
  }

  public Iterator<Item> iterator() {
    return new DoublyLinkedListIterator();
  }

  private class DoublyLinkedListIterator implements Iterator<Item> {
    private int i = N;
    private Node nextNode = first;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      Node oldNext = nextNode;
      nextNode = nextNode.next;
      i--;

      return oldNext.item;
    }
  }
}
