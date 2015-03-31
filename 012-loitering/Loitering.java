public class Loitering {
  public static void main(String[] argv) {
    LoiteringStack<Integer> stack = new LoiteringStack<Integer>(10);

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      stack.push(i);
    }

    while (!stack.isEmpty()) {
      StdOut.printf("%d \n", stack.pop());
    }
  }
}
