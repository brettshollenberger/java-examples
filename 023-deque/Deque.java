public class Deque<Item> {
  private Node first;
  private Node last;
  private int N = 0;

  private class Node {
    Item item;
    Node next;
    Node prev;
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void pushLeft(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) first = last = newNode;
    else {
      newNode.next = first;
      first.prev   = newNode;
      first        = newNode;
    }

    N++;
  }

  public void pushRight(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) first = last = newNode;
    else {
      last.next    = newNode;
      newNode.prev = last;
      last         = newNode;
    }

    N++;
  }

  public Item popLeft() {
    if (isEmpty()) return null;

    Node popped = first;

    if (popped.next != null) {
      first       = popped.next;
      first.prev  = null;
    }

    N--;

    return popped.item;
  }
  
  public Item popRight() {
    if (isEmpty()) return null;

    Node popped = last;

    if (popped.prev != null) {
      last = popped.prev;
      last.next = null;
    }

    N--;

    return popped.item;
  }
}
