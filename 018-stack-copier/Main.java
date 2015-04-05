public class Main {
  public static void main(String[] argv) {
    Copier<String> copier = new Copier<String>();
    Stack<String> stack   = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String str = StdIn.readString();

      stack.push(str);
    }

    Stack<String> copy = copier.copy(stack);

    for (String str: copy) {
      StdOut.printf("%s ", str);
    }
  }
}
