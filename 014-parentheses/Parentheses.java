public class Parentheses {
  public static void main(String[] argv) {
    Stack<Character> stack = new Stack<Character>();
    boolean truth = true;

    while (!StdIn.isEmpty()) {
      char s = StdIn.readChar();

      if (s == '(' || s == '[' || s == '{') {
        stack.push(s);
      } else if (s == ')') {
        if (stack.pop() != '(') truth = false;
      } else if (s == ']') {
        if (stack.pop() != '[') truth = false;
      } else if (s == '}') {
        if (stack.pop() != '{') truth = false;
      }
    }

    StdOut.printf("Balanced: %s", truth == true ? "true" : "false");
  }
}
