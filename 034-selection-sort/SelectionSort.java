public class SelectionSort {
  public static <Item extends Comparable<Item>> void sort(Item[] items) {
    for (int i = 0; i < items.length; i++) {
      Item nextSmallest = items[i];
      int nextSmallestIndex   = i;

      for (int j = i+1; j < items.length; j++) {
        if (nextSmallest.compareTo(items[j]) == 1) { 
          nextSmallest      = items[j];
          nextSmallestIndex = j;
        }
      }

      swap(items, i, nextSmallestIndex);
    }
  }

  public static <Item extends Comparable<Item>> void swap(Item[] items, int i, int j) {
    Item tmp = items[i];
    items[i] = items[j];
    items[j] = tmp;
  }
}
