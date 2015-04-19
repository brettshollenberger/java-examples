public class Main {
  public static void main(String[] argv) {
    int totalComponents   = Integer.parseInt(StdIn.readLine());
    WeightedQuickUnion qu = new WeightedQuickUnion(totalComponents);
    Stopwatch unionTimer  = new Stopwatch();
    String line           = "";

    while (!StdIn.isEmpty() && !(line = StdIn.readLine()).equals("connected")) {
      String[] components = line.split(" ");
      int i1              = Integer.parseInt(components[0]);
      int i2              = Integer.parseInt(components[1]);

      qu.union(i1, i2);
    }

    StdOut.printf("Unions: %7f", unionTimer.elapsedTime());
    StdOut.println();

    Stopwatch connectedTimer = new Stopwatch();

    while (!StdIn.isEmpty()) {
      String[] components = StdIn.readLine().split(" ");
      int i1              = Integer.parseInt(components[0]);
      int i2              = Integer.parseInt(components[1]);

      qu.connected(i1, i2);
    }

    StdOut.printf("Connected: %7f", connectedTimer.elapsedTime());

    StdOut.println();
    StdOut.println();
  }
}
