import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
  private Node top;
  private int count = 0;

  private class Node {
    Item item;
    Node next;
  }

  public void push(Item item) {
    Node second = top;
    top = new Node();
    top.item = item;
    top.next = second;
    count++;
  }

  public Item pop() {
    Node result = top;
    top = result.next;
    count--;
    return result.item;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public int size() {
    return count;
  }

  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    private Node nextNode = top;
    private int i = count;

    public boolean hasNext() { return i > 0; }

    public Item next() { 
      Node node = nextNode;
      nextNode  = node.next;
      i--;

      return node.item;
    }

    public void remove() { }
  }
}
