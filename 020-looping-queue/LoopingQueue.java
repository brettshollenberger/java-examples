public class LoopingQueue<Item> {
  private Node head;
  private Node tail;
  private int N = 0;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void enqueue(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) head = tail = newNode;
    else {
      tail.next    = newNode;
      newNode.next = head;
      tail         = newNode;
    }

    N++;
  }

  public Item dequeue() {
    if (isEmpty()) return null;

    Node oldHead = head;

    if (oldHead.next == oldHead) {
      head = new Node();
    } else {
      tail.next    = oldHead.next;
      head         = oldHead.next;
    }

    N--;

    return oldHead.item;
  }
}
