public class Main {
  public static double nSquaredTimeTrial(int N) {
    int MAX = 10000;
    NSquaredRandomQueue<Integer> nSquaredQueue = new NSquaredRandomQueue<Integer>(1);

    for (int i = 0; i < N; i++) {
      nSquaredQueue.enqueue(StdRandom.uniform(-MAX, MAX));
    }

    Stopwatch timer = new Stopwatch();
    for (int i : nSquaredQueue);
    return timer.elapsedTime();
  }

  public static double knuthTimeTrial(int N) {
    int MAX = 10000;
    KnuthRandomQueue<Integer> knuthQueue = new KnuthRandomQueue<Integer>(1);

    for (int i = 0; i < N; i++) {
      knuthQueue.enqueue(StdRandom.uniform(-MAX, MAX));
    }

    Stopwatch timer = new Stopwatch();
    for (int i : knuthQueue);
    return timer.elapsedTime();
  }

  public static void main(String[] argv) {
    for (int N = 2; N <= 1073741824; N += N) {
      double time = nSquaredTimeTrial(N);

      StdOut.printf("%7d %5.1f\n", N, time);
    }
  }
}
