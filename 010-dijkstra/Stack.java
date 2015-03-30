public class Stack<Item> {
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
}
