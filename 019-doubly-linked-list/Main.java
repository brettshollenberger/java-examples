public class Main {
  public static void main(String[] argv) {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      dll.push(i);
    }

    StdOut.printf("Find 3: %s \n", dll.find(3) == true ? "true" : "false");
    StdOut.printf("Remove 3: %d \n", dll.remove(3));
    StdOut.printf("Find 3: %s \n", dll.find(3) == true ? "true" : "false");
  }
}
