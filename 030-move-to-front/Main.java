public class Main {
  public static void main(String[] argv) {
    SelfOrganizingQueue<Integer> q = new SelfOrganizingQueue<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      q.enqueue(i);
    }

    for (int i : q) {
      StdOut.printf("%d \n", i);
    }
  }
}
