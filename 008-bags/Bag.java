public class Bag<Item> {
  private Item[] bag;
  private int len = 0;

  public Bag(int cap) {
    bag = (Item[]) new Object[cap];
  }

  void add(Item item) {
    bag[len++] = item;
  }

  boolean isEmpty() {
    return len == 0;
  }

  int size() {
    return len;
  }

  static public void main(String[] argv) {
    Bag bag = new Bag(1000);

    while (!StdIn.isEmpty()) {
      bag.add(StdIn.readInt());
    }

    StdOut.printf("Bag contains %d items", bag.size());
  }
}
