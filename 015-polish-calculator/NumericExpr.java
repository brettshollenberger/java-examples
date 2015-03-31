public class NumericExpr implements Expr {
  int i;

  public NumericExpr(int j) {
    i = j;
  }

  public int reduce() {
    return i;
  }
}
