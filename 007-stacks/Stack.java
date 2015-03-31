public class Stack<Item> {
  private Node first;
  private int N;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node second = first;
    first = new Node();
    first.item = item;
    first.next = second;
    N++;
  }

  public Item pop() {
    Item popped = first.item;
    first = first.next;
    N--;
    return popped;
  }

  public Item peek() {
    return first.item;
  }

  public static void main(String[] argv) {
    Stack<Integer> stack = new Stack<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      stack.push(i);

      StdOut.printf("Size: %d \n", stack.size());
    }

    while (!stack.isEmpty()) {
      int i = stack.pop();

      StdOut.printf("Most recent item was: %d \n", i);
    }
  }
}
