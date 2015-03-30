public class Queue<Item> {
  private Item[] queue;
  private int nextEnqueue = 0, nextDequeue = 0;

  public Queue(int cap) {
    queue = (Item[]) new Object[cap+1];
  }

  void enqueue(Item item) {
    if (nextEnqueue == queue.length-1) {
      nextEnqueue = 0;
    }

    if (nextEnqueue != nextDequeue-1){
      queue[nextEnqueue++] = item;
    } else {
      StdOut.printf("Error: Queue full \n");
    }
  }

  Item dequeue() {
    if (nextDequeue == queue.length-1) {
      nextDequeue = 0;
    }

    if (nextDequeue != nextEnqueue) {
      return queue[nextDequeue++];
    } else {
      return null;
    }
  }

  boolean isEmpty() {
    return nextDequeue == nextEnqueue;
  }

  int size() {
    return nextEnqueue - nextDequeue;
  }

  public static void main(String[] argv) {
    Queue<Integer> queue = new Queue<Integer>(6);
    int[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int i;

    for (i = 0; i < 5; i++) {
      queue.enqueue(ints[i]);
    }

    while (!queue.isEmpty()) {
      StdOut.printf("Next %d \n", queue.dequeue());
    }

    for (i = 5; i < 10; i++) {
      queue.enqueue(ints[i]);
    }

    while (!queue.isEmpty()) {
      StdOut.printf("Next %d \n", queue.dequeue());
    }
  }
}
