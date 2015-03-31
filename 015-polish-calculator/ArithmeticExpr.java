public class ArithmeticExpr implements Expr {
  private Expr left;
  private Expr right;
  private String operation;

  public ArithmeticExpr(Object l, Object r, String op) {
    left      = (Expr)l;
    right     = (Expr)r;
    operation = op;
  }

  public int reduce() {
    int l = left.reduce();
    int r = right.reduce();

    if (operation.equals("+"))      return l + r;
    else if (operation.equals("-")) return l - r;
    else if (operation.equals("*")) return l * r;
    else if (operation.equals("/")) return l / r;

    return -1;
  }
}
