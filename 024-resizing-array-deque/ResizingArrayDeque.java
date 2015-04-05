public class ResizingArrayDeque<Item> {
  private Item[] items;
  private int N = 0;

  public ResizingArrayDeque(int cap) {
    items = (Item[]) new Object[cap];
  }

  private void resize(int cap) {
    Item[] newItems = (Item[]) new Object[cap];

    for (int i = 0; i < N; i++) {
      newItems[i] = items[i];
    }

    items = newItems;
  }

  // O(n) shift items back starting at a given index
  //
  // [1, 2, 3, 4, 5]
  // shift(1) => [1, 2, 2, 3, 4, 5]
  //
  // [10, 20, 30, 40]
  // shift(0) => [10, 10, 20, 30, 40]
  //
  private void shift(int startIndex) {
    for (int stopIndex = N-1; stopIndex >= startIndex; stopIndex--) {
      items[stopIndex+1] = items[stopIndex];
    }
  }

  // O(n) shift items forward starting at a given index
  //
  // [10, 20, 30, 40]
  // unshift(0) => [20, 30, 40, null]
  //
  private void unshift(int startIndex) {
    for (; startIndex < N; startIndex++) {
      Item val = (N == items.length && startIndex == N-1) ? null : items[startIndex+1];
      items[startIndex] = val;
    }
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void pushLeft(Item item) {
    if (N == items.length) { resize(N*2); }

    shift(0);

    items[0] = item;
    N++;
  }

  public void pushRight(Item item) {
    if (N == items.length) { resize(N*2); }

    items[N++] = item;
  }

  public Item popLeft() {
    Item val = items[0];
    unshift(0);
    N--;
    return val;
  }

  public Item popRight() {
    Item val = items[--N];
    items[N] = null;
    return val;
  }
}
