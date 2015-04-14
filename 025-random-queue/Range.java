public class Range {
  public static int[] range(int from, int to) {
    int currentValue = from;
    int iterations   = (to-from)+1;
    int[] r = new int[iterations];

    for (int i = 0; i < iterations; i++) {
      r[i] = currentValue++;
    }

    return r;
  }
}
