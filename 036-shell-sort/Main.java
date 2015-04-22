public class Main {
  public static void main(String[] argv) {
    int size = StdIn.readInt();
    Integer[] nums = new Integer[size];

    for (int i = 0; i < size; i++) {
      nums[i] = StdIn.readInt();
    }

    Stopwatch stopwatch = new Stopwatch();

    ShellSort.sort(nums);

    StdOut.printf("N: %d \n", size);
    StdOut.printf("Elapsed Time: %f \n", stopwatch.elapsedTime());
  }
}
