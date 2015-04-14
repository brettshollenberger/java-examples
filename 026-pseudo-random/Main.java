import java.util.Random;

public class Main {
  public static void main(String[] argv) {
    Random rand = new Random(1);
    Random rand2 = new Random(1);

    for (int i = 0; i < 10; i++) {
      StdOut.printf("%d \n", rand.nextInt(10));
    }

    StdOut.println();
    StdOut.printf("--------");
    StdOut.println();
    
    for (int i = 0; i < 10; i++) {
      StdOut.printf("%d \n", rand2.nextInt(10));
    }
  }
}
