public class UnionFindTimeTrial<UFAlgorithm> {
  private Class<UFAlgorithm> ufAlgorithmClass;

  public UnionFindTimeTrial(Class<UFAlgorithm> ufClass) {
    ufAlgorithmClass = ufClass;
  }

  public void run() {
    int totalComponents  = Integer.parseInt(StdIn.readLine());
    UFAlgorithm uf       = ufAlgorithmClass.newInstance(totalComponents);
    Stopwatch unionTimer = new Stopwatch();
    String line          = "";

    while (!StdIn.isEmpty() && !(line = StdIn.readLine()).equals("connected")) {
      String[] components = line.split(" ");
      int i1              = Integer.parseInt(components[0]);
      int i2              = Integer.parseInt(components[1]);

      uf.union(i1, i2);
    }

    StdOut.printf("Unions: %7f", unionTimer.elapsedTime());
    StdOut.println();

    Stopwatch connectedTimer = new Stopwatch();

    while (!StdIn.isEmpty()) {
      String[] components = StdIn.readLine().split(" ");
      int i1              = Integer.parseInt(components[0]);
      int i2              = Integer.parseInt(components[1]);

      uf.connected(i1, i2);
    }

    StdOut.printf("Connected: %7f", connectedTimer.elapsedTime());

    StdOut.println();
    StdOut.println();
  }
}
