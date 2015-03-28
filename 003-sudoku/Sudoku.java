public class Sudoku {
  public static void main(String[] args) {
    int[][] squares = new int[9][9];
    int x, y;

    for (y = 0; y < 9; y++) {
      for (x = 0; x < 9; x++) {
        System.out.printf("coordinate (%d|%d): %d \n", x, y, squares[y][x]);
      }
    }
  }
}
