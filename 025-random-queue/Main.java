public class Main {
  public static void main(String[] argv) {
    RandomQueue<Integer> randomQueue = new RandomQueue<Integer>(1);

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();
      randomQueue.enqueue(i);
    }

    for (int i : randomQueue) {
      StdOut.printf("i: %d\n", i);
    }
  }
}
