public class ReversibleLL<Item> {
  private Node first;
  private Node last;
  private int N;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() { return N == 0; }

  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;

    if (isEmpty()) first = last;
    else oldlast.next = last;

    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) last = null;
    return item;
  }

  public void reverse() {
    Node R = null;

    while (first != null) {
      Node second = first.next;
      first.next  = R;
      R           = first;
      first       = second;
    }

    first = R;
  }
}
