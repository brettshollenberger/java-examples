public class Main {
  public static void main(String[] argv) {
    ReversibleLL<Integer> reversible = new ReversibleLL<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      reversible.enqueue(i);
    }

    reversible.reverse();

    while (!reversible.isEmpty()) {
      StdOut.printf("%d\n", reversible.dequeue());
    }
  }
}
