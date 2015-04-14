public class Main {
  public static void main(String[] argv) {
    Stack<Integer> stack = new Stack<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      stack.push(i);
    }

    Stack<Integer> clone = stack.copy();

    for (int i : clone) {
      StdOut.printf("Cloned: %d \n", i);
    }
  }
}
