public class Main {
  public static void main(String[] argv) {
    LoopingQueue<Integer> lq = new LoopingQueue<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      lq.enqueue(i);
    }

    while (!lq.isEmpty()) {
      StdOut.printf("%d \n", lq.dequeue());
    }
  }
}
