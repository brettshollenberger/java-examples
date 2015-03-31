public class Main {
  public static void main(String[] argv) {
    Queue<Integer> queue = new Queue<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      queue.enqueue(i);
    }

    while (!queue.isEmpty()) {
      StdOut.printf("%d\n", queue.dequeue());
    }
  }
}
