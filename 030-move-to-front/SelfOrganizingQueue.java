import java.util.Iterator;

public class SelfOrganizingQueue<Item> implements Iterable<Item> {
  private Node head;
  private Node tail;
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

  // Move-to-front self-organizing enqueue action:
  //
  // If the item is already in the list, move it to the front; otherwise,
  // enqueue a new node as normal
  public void enqueue(Item item) {
    Node existingNode = findNode(item);

    if (existingNode == null) {
      enqueueNode(item);
    } else {
      deleteNode(existingNode);
      existingNode.prev = null;
      existingNode.next = head;
      head.prev         = existingNode;
      head              = existingNode;
    }
  }

  // The classic enqueue item action:
  //
  // Insert the item in a new node at the end of the queue
  private void enqueueNode(Item item) {
    Node newNode = new Node();
    newNode.item = item;

    if (isEmpty()) { head = tail = newNode; }
    else {
      newNode.prev = tail;
      tail.next    = newNode;
      tail         = newNode;
    }

    N++;
  }

  public Item dequeue() {
    if (isEmpty()) { return null; }

    Node oldHead = head;

    if (oldHead.next == null) { head = null; }
    else                      { head = oldHead.next; }

    N--;

    return oldHead.item;
  }

  private Node deleteNode(Node nodeToDelete) {
    if (nodeToDelete != null) {
      if (nodeToDelete.prev != null) {
        nodeToDelete.prev.next = nodeToDelete.next;

        if (nodeToDelete.next != null) { nodeToDelete.next.prev = nodeToDelete.prev; }
      } else {
        head = nodeToDelete.next;
      }
    }

    return nodeToDelete;
  }

  private Item deleteItem(Item itemToDelete) {
    Node nodeToDelete = findNode(itemToDelete);
    Node deletedNode = deleteNode(nodeToDelete);

    if (deletedNode == null) { return null; }
    else                     { return deletedNode.item; }
  }

  private Node findNode(Item itemToFind) {
    QueueNodeIterator nodeIterator = new QueueNodeIterator();
    Node thisNode = new Node();

    while (nodeIterator.hasNext() && (thisNode = nodeIterator.next()) != null && thisNode.item != itemToFind);

    if (thisNode.item == itemToFind) { return thisNode; }
    else { return null; }
  }

  public QueueIterator iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    Node next = head;
    int I = N;

    public boolean hasNext() {
      return I > 0;
    }

    public Item next() { 
      Node oldNext = next;
      next = oldNext.next;
      I--;

      return oldNext.item;
    }
  }

  private class QueueNodeIterator {
    Node next = head;
    int I = N;

    public boolean hasNext() {
      return I > 0;
    }

    public Node next() { 
      Node oldNext = next;
      next = oldNext.next;
      I--;

      return oldNext;
    }
  }
}
