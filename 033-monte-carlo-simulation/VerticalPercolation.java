import java.util.Hashtable;

public class VerticalPercolation {
  private int size;
  private int[][] components;

  private enum ComponentTypes { 
    BLOCKED(0), OPEN(1), FULL(2);

    private int value;

    private ComponentTypes(int i) {
      this.value = i;
    }
  }

  public VerticalPercolation(int sz) {
    size = sz;
    components = new int[size][size];

    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        components[row][col] = blocked();
      }
    }
  }

  public boolean percolates() {
    flow();

    for (int col = 0; col < size; col++) {
      if (fullColumn(col)) { return true; }
    }

    return false;
  }

  private boolean fullColumn(int col) {
    boolean truth = true;

    for (int row = 0; row < size; row++) {
      if (!isFull(col, row)) { 
        truth = false; 
        break;
      }
    }

    return truth;
  }

  private void flow() { 
    for (int col = 0; col < size; col++) {
      for (int row = 0; row < size; row++) {
        if (isFull(col, row) || (isOpen(col, row)) && isFull(col, row-1)) { 
          components[row][col] = full(); 
        }
        else { break; }
      }
    }
  }

  private boolean isOpen(int col, int row) {
    return find(col, row) == open();
  }

  private boolean isFull(int col, int row) {
    if (row < 0) { return true; }
    return find(col, row) == full();
  }

  // Retrieve the status of the component in human-readable form
  //
  public String status(int col, int row) {
    return ComponentTypes.values()[find(col, row)].name();
  }

  public void open(int col, int row) {
    components[row][col] = open();
  }

  private int find(int col, int row) {
    return components[row][col];
  }

  // Return the value of blocked, open, or full magic numbers
  //
  private int blocked() { return ComponentTypes.BLOCKED.ordinal(); }
  private int open() { return ComponentTypes.OPEN.ordinal(); }
  private int full() { return ComponentTypes.FULL.ordinal(); }
}
