import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
  private Node head;
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

  public Stack<Item> copy() {
    Stack<Item> reverseClone = new Stack<Item>();
    Stack<Item> clone = new Stack<Item>();

    for (Item item : this) { reverseClone.push(item); }

    for (Item item : reverseClone) { clone.push(item); }

    return clone;
  }

  public void push(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) { head = newNode; }
    else {
      newNode.next = head;
      head = newNode;
    }

    N++;
  }

  public Item pop() {
    if (isEmpty()) { return null; }

    Node oldHead = head;
    head = head.next;

    N--;

    return oldHead.item;
  }

  public StackIterator iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    private Node next = head;
    private int S = N;

    public boolean hasNext() {
      return S > 0;
    }

    public Item next() {
      Node oldNext = next;
      next = next.next;
      S--;

      return oldNext.item;
    }
  }
}
