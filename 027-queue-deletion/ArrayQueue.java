import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {
  private Item[] items;
  private int N = 0;

  public ArrayQueue(int cap) {
    items = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void enqueue(Item item) {
    if (needsDoubling()) { doubleLength(); }

    items[N++] = item;
  }

  public Item dequeue() {
    if (needsHalving()) { halveLength(); }

    return items[--N];
  }

  public Item delete(int k) {
    if (k >= N) { return null; }

    Item item = items[k];

    for (int i = k; i+1 < N; i++) {
      items[i] = items[i+1];
    }

    N--;

    return item;
  }

  public ArrayQueueIterator iterator() {
    return new ArrayQueueIterator();
  }

  private class ArrayQueueIterator implements Iterator<Item> {
    int L = 0;

    public boolean hasNext() {
      return L < N;
    }

    public Item next() { 
      return items[L++];
    }
  }

  private boolean needsDoubling() {
    return N == items.length;
  }

  private boolean needsHalving() {
    return N <= (items.length/2);
  }

  private void doubleLength() {
    Item[] newItems = (Item[]) new Object[items.length*2];

    copyItems(newItems);
  }

  private void halveLength() {
    Item[] newItems = (Item[]) new Object[items.length/2];

    copyItems(newItems);
  }

  private void copyItems(Item[] newItems) {
    for (int i = 0; i < N; i++) {
      newItems[i] = items[i];
    }

    items = newItems;
  }
}
