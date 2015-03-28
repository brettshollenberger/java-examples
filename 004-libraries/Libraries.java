import java.util.Arrays;

public class Libraries {
  public static void main(String[] args) {

    // Type 1: Standard System Libraries
    System.out.printf("----------------------------\n");
    System.out.println();
    System.out.printf("Type 1: Standard System Libraries \n");
    System.out.printf("These do not need import statments; they're built in. \n");
    System.out.printf("Examples: System (used for printf), Math, Integer, Double, String, StringBuilder \n");
    System.out.println();
    System.out.printf("Here, System + Math work together to compute the absolute value of -2: %d \n", Math.abs(-2));
    System.out.printf("Here, Integer converts the string '2' to its integer value %d", Integer.parseInt("2"));
    System.out.println();
    System.out.printf("----------------------------\n");
    System.out.println();


    // Type 2: Imported System Libraries
    int[] arr = {5, 4, 3, 2, 1};
    Arrays.sort(arr);

    System.out.printf("Type 2: Imported System Libraries \n");
    System.out.printf("These must be imported. \n");
    System.out.printf("Example: 'import java.util.Arrays;' \n");
    System.out.println();
    System.out.printf("To use, we must call the library name, like Arrays.sort(arr) \n");
    for (int n:arr) System.out.printf("%3d", n);
    System.out.println();
    System.out.println();
    System.out.printf("----------------------------\n");
    System.out.println();

  }
}
