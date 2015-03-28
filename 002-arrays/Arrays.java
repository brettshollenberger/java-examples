public class Arrays {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    int[] b = new int[4];
    int i;

    for (i = 0; i < 4; i++) {
      System.out.printf("%d\n", a[i]);
      System.out.printf("%d\n", b[i]);
    }
  }
}
