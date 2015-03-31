public class Queue<Item> {
  private Node first = new Node();
  private Node last = new Node();
  private int N = 0;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

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
}
