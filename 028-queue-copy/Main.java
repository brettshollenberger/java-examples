public class Main {
  public static void main(String[] argv) {
    Queue<Integer> queue = new Queue();

    while (!StdIn.isEmpty()) { 
      int i = StdIn.readInt();

      queue.enqueue(i);
    }

    Queue<Integer> clone = queue.copy();

    for (int j : clone) {
      StdOut.printf("Cloned: %d \n", j);
    }
  }
}
