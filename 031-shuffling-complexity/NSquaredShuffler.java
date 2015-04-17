import java.util.Random;

public class NSquaredShuffler {
  public static void shuffle(int[] items) {
    Random rand          = new Random();
    int max              = items.length;
    int[] remainingItems = items.clone();
    int randSize         = remainingItems.length;

    for (int i = 0; i < max; i++) {
      // generate a number between i & max
      int randomIndex = rand.nextInt(randSize--);

      items[i] = remainingItems[randomIndex];
      deleteFromArray(remainingItems, randomIndex);
    }
  }

  private static void deleteFromArray(int[] array, int index) {
    for (int i = index; i < array.length-1; i++) {
      array[i] = array[i+1];
    }
  }
}
