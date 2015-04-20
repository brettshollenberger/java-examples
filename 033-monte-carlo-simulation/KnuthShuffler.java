import java.util.Random;

// The Knuth Shuffle operates in O(n) time, significantly
// improving on shuffle operations which perform in O(n^2).
//
// To achieve this time complexity, the shuffler shuffles
// each index in order:
//
// [ 0, 1, 2, 3, 4, 5 ]
//   ^
//   |
// Sample a random integer from 0-5 (4)
//
// Swap (n, rand) (e.g. swap(0, 4)):
//
// [ 4, 1, 2, 3, 0, 5 ]
//   ^
//   |
// Now the 0th element is successfully shuffled.
//
// Proceed, where the next sampling is of the numbers 1-5, as the 0th
// element can no longer be produced.
//
public class KnuthShuffler {
  public static void shuffle(int[] items) {
    Random rand = new Random();
    int max = items.length;

    for (int i = 0; i < max; i++) {
      // generate a number between i & max
      int randomIndex = rand.nextInt(max-i) + i;

      swap(items, i, randomIndex);
    }
  }

  private static void swap(int[] array, int i, int j) {
    int tmp  = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
