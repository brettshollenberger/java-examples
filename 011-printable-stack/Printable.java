public class Printable {
  public static void main(String[] argv) {
    Queue<Integer> queue = new Queue<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();

      queue.enqueue(i);
    }

    int width = queue.size()*3;

    StdOut.printf("| StdIn | StdOut | N |%-" + width + "s|\n", "a[]");

    while (!queue.isEmpty()) {
      int i = queue.dequeue();

      stack.push(i);

      StdOut.printf("|%7d|        |%3d|", i, stack.size());

      String str = " ";

      for (int item: stack) {
        str += item + " ";
      }

      StdOut.printf("%-" + width + "s|\n", str);
    }

    while (!stack.isEmpty()) {
      StdOut.printf("|       |%8d|%3d|", stack.pop(), stack.size());
      
      String str = " ";

      for (int item: stack) {
        str += item + " ";
      }

      StdOut.printf("%-" + width + "s|\n", str);
    }
  }
}
