import java.util.Arrays;

public class Polish {
  public static boolean isNumeric(String s)  {  
    try  {  
      double d = Double.parseDouble(s);  
    } catch(NumberFormatException nfe)  {  
      return false;  
    }  
    return true;  
  }

  public static void main(String[] argv) {
    Stack<Expr> stack = new Stack<Expr>();
    String[] operations = {"+", "-", "*", "/"};

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (isNumeric(s)) {
        NumericExpr num = new NumericExpr(Integer.parseInt(s));
        stack.push(num);
      } else if (Arrays.asList(operations).contains(s)) {
        NumericExpr right  = new NumericExpr(stack.pop().reduce());
        NumericExpr left   = new NumericExpr(stack.pop().reduce());
        ArithmeticExpr exp = new ArithmeticExpr(left, right, s);

        stack.push(exp);
      }
    }

    StdOut.printf("Result: %d", stack.pop().reduce());
  }
}
