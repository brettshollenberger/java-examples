public class Dijkstra {
  public static void main(String[] argv) {
    Stack<Double> vals = new Stack<Double>();
    Stack<String> ops   = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("("));
      else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) ops.push(s);
      else if (s.equals(")")) {
        double v = vals.pop();
        String op = ops.pop();

        if (op.equals("+"))      v = vals.pop() + v;
        else if (op.equals("-")) v = vals.pop() - v;
        else if (op.equals("*")) v = vals.pop() * v;
        else if (op.equals("/")) v = vals.pop() / v;

        vals.push(v);
      }
      else vals.push(Double.parseDouble(s));
    }

    StdOut.println(vals.pop());
  }
}
