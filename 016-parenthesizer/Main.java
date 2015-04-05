public class Main {
  public static void main(String[] argv) {
    Stack<String> stack = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String str = StdIn.readString();

      if (str.equals(")")) {
        String right  = stack.pop();
        String middle = stack.pop();
        String left   = stack.pop();
        
        str = "( " + left + " " + middle + " " + right + " )";
      }

      stack.push(str);
    }

    while (!stack.isEmpty()) {
      StdOut.printf("%s", stack.pop());
    }
  }
}
