public class Counter {
  int count = 0;

  public int increment() {
    return ++count;
  }

  public int count() {
    return count;
  }

  public static void main(String[] args) {
    Counter c = new Counter();

    while (!StdIn.isEmpty()) {
      StdIn.readChar();
      c.increment();
    }

    StdOut.printf("File length: %d", c.count());
  }
}
