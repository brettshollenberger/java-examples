public class Main {
  public static void main(String[] argv) {
    ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<Integer>(1);

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      if (i % 2 == 0) {
        deque.pushLeft(i);
      } else {
        deque.pushRight(i);
      }
    }

    while (!deque.isEmpty()) {
      StdOut.printf("%d \n", deque.popLeft());
    }
  }
}
