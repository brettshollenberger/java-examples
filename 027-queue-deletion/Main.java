public class Main {
  public static void main(String[] argv) {
    ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(1);
    LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      arrayQueue.enqueue(i);
      linkedListQueue.enqueue(i);
    }

    StdOut.printf("Deleted 2nd element: %d \n", arrayQueue.delete(1));
    StdOut.printf("Deleted 2nd element: %d \n", linkedListQueue.delete(1));

    StdOut.println();
    StdOut.println("Printing array queue");
    StdOut.println();

    for (int i : arrayQueue) {
      StdOut.printf("%d \n", i);
    }

    StdOut.println();
    StdOut.println("Printing linked list queue");
    StdOut.println();
    for (int i : linkedListQueue) {
      StdOut.printf("%d \n", i);
    }
  }
}
