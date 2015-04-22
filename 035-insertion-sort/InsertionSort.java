public class InsertionSort {
  public static <Item extends Comparable<Item>> void sort(Item[] items) {
    for (int i = 0; i < items.length; i++) {
      int q = i;
      for (int j = i-1; j > -1 && items[j].compareTo(items[q]) == 1; j--) {
        swap(items, q, j);
        q = j;
      }
    }
  }

  public static <Item extends Comparable<Item>> void swap(Item[] items, int i, int j) {
    Item tmp = items[i];
    items[i] = items[j];
    items[j] = tmp;
  }
}
