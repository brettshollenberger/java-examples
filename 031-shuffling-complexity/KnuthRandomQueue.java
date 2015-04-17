import java.util.Iterator;

public class KnuthRandomQueue<Item> implements Iterable<Item> {
  private Item[] elements;
  private int N = 0;

  public KnuthRandomQueue(int cap) {
    elements = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private boolean insertionOverflow() {
    return N == elements.length;
  }

  private void doubleLength() {
    Item[] doubled = (Item[]) new Object[elements.length*2];

    for (int i = 0; i < elements.length; i++) {
      doubled[i] = elements[i];
    }

    elements = doubled;
  }

  public void enqueue(Item item) {
    if (insertionOverflow()) { doubleLength(); }

    elements[N++] = item;
  }

  public Item dequeue() {
    return elements[--N];
  }

  public RandomIterator iterator() {
    return new RandomIterator();
  }

  private class RandomIterator implements Iterator<Item> {
    private int[] possibleIndices = Range.range(0, N-1);
    private int R = N;

    public RandomIterator() {
      KnuthShuffler.shuffle(possibleIndices);
    }

    public boolean hasNext() {
      return R > 0;
    }

    public Item next() { 
      if (!hasNext()) { return null; }

      return elements[possibleIndices[--R]];
    }
  }
}
