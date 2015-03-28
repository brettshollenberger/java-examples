public class Command {
  public static void main(String[] argv) {
    int i;

    for (i = 0; i < argv.length; i++) {
      System.out.printf("%d\n", Integer.parseInt(argv[i]));
    }
  }
}
