public class ShellSort {
  public static <Item extends Comparable<Item>> void sort(Item[] items) {
    int N = items.length;
    int h = 1;

    while (h < N/3) { h = h*3 + 1; } // 1, 4, 13, 40, 121 ...

    while (h >= 1) {
      insertion_sort(items, h);
      h = h/3;
    }
  }

  public static <Item extends Comparable<Item>> void insertion_sort(Item[] items, int k) {
    for (int i = k; i < items.length; i += k) {
      int q = i;
      for (int j = i-k; j > -1 && items[j].compareTo(items[q]) == 1; j -= k) {
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
