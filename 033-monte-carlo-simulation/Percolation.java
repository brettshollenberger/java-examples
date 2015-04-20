import java.util.Hashtable;

public class Percolation {
  private int size;
  private Component[] components;
  private int[] sizes;
  private int openSites = 0;

  public class Component {
    int parent;
    int status;
    int[] neighbors;

    public String toString() {
      return String.format("{parent: %d, status: %d}", parent, status);
    }
  }

  private enum ComponentStatuses { 
    BLOCKED(0), OPEN(1), FULL(2);

    private int value;

    private ComponentStatuses(int i) {
      this.value = i;
    }
  }

  public Percolation(int sz) {
    size       = sz;
    components = new Component[size*size];
    sizes      = new int[size*size];

    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        int index = rowColToIndex(row, col);

        sizes[index] = 1;

        components[index]           = new Component();
        components[index].parent    = index;
        components[index].status    = blocked();
        components[index].neighbors = generateNeighbors(row, col);
      }
    }
  }

  public boolean percolates() { 
    for (int lastRowStart = size * (size-1); lastRowStart < (size*size); lastRowStart++) {
      if (reachable(lastRowStart)) { return true; }
    }

    return false;
  }

  private int[] generateNeighbors(int row, int col) {
    int top, bottom, left, right;
    top = bottom = left = right = -1;

    if (row != 0)      { top    = rowColToIndex(row-1, col); }
    if (row != size-1) { bottom = rowColToIndex(row+1, col); }
    if (col != 0)      { left   = rowColToIndex(row, col-1); }
    if (col != size-1) { right  = rowColToIndex(row, col+1); }

    return new int[]{top, bottom, left, right};
  }

  // Retrieve the status of the component in human-readable form
  //
  public String status(int col, int row) {
    return ComponentStatuses.values()[find(col, row).status].name();
  }

  public void open(int idx) {
    int[] rowCol = indexToRowCol(idx);
    int row = rowCol[0];
    int col = rowCol[1];
    open(col, row);
  }

  public void open(int col, int row) {
    int index = rowColToIndex(row, col);

    openSites += 1;

    components[index].status = open();

    for (int neighbor : components[index].neighbors) {
      if (neighbor != -1 && (isOpen(neighbor) || isFull(neighbor))) { union(index, neighbor); }
    }

    fill(index);
  }

  public double percentSitesOpen() {
    return (float) openSites / (size*size);
  }

  private boolean inFirstRow(int index) {
    int[] rowCol = indexToRowCol(index);
    int row = rowCol[0];
    int col = rowCol[1];

    return inFirstRow(row, col);
  }

  private boolean inFirstRow(int row, int col) {
    return row == 0;
  }

  private boolean inLastRow(int index) {
    int[] rowCol = indexToRowCol(index);
    int row = rowCol[0];
    int col = rowCol[1];

    return inLastRow(row, col);
  }

  private boolean inLastRow(int row, int col) {
    return row == size-1;
  }

  private void fill(int index) {
    if (inFirstRow(index) && components[index].status == open()) {
      components[index].status = full();
      Component root = findRoot(index);
      root.status = full();
    }
  }

  public boolean reachable(int index) {
    int[] rowCol = indexToRowCol(index);
    int row = rowCol[0];
    int col = rowCol[1];

    return reachable(col, row);
  }

  public boolean reachable(int col, int row) {
    return findRoot(col, row).status == full();
  }

  private void union(int i, int j) {
    int isRoot = findRootIndex(i);
    int jsRoot = findRootIndex(j);

    if (isRoot != jsRoot) {
      int isSize = sizes[isRoot];
      int jsSize = sizes[jsRoot];

      // balance subtrees based on subtree size
      if (isSize >= jsSize) {
        // j is smaller
        components[jsRoot].parent = isRoot;
        sizes[isRoot] += jsSize;
        if (components[jsRoot].status == full()) { components[isRoot].status = full(); }
      } else {
        // i is smaller
        components[isRoot].parent = jsRoot;
        sizes[jsRoot] += isSize;
        if (components[isRoot].status == full()) { components[jsRoot].status = full(); }
      }
    }
  }

  public Component find(int col, int row) {
    return components[rowColToIndex(row, col)];
  }

  public Component find(int idx) {
    return components[idx];
  }

  private int findRootIndex(int idx) {
    return findRoot(idx).parent;
  }

  private Component findRoot(int idx) {
    while (idx != components[idx].parent) { idx = components[idx].parent; }
    return components[idx];
  }

  private Component findRoot(int col, int row) {
    int idx = rowColToIndex(row, col);
    return findRoot(idx);
  }

  // Cells are a part of the same open component
  //
  public boolean connected(int i, int j) {
    return findRootIndex(i) == findRootIndex(j);
  }

  private int rowColToIndex(int row, int col) { 
    return (row*size) + col;
  }

  private int[] indexToRowCol(int index) { 
    int row = 0;
    int col = 0;

    while (index >= size) {
      row += 1;
      index -= size;
    }

    col = index;

    return new int[]{row, col};
  }

  private boolean isOpen(int col, int row) {
    return find(col, row).status == open();
  }

  private boolean isOpen(int idx) {
    return find(idx).status == open();
  }

  private boolean isFull(int col, int row) {
    if (row < 0) { return true; }
    return find(col, row).status == full();
  }

  private boolean isFull(int idx) {
    int[] rowCol = indexToRowCol(idx);
    int row      = rowCol[0];
    int col      = rowCol[1];

    return isFull(col, row);
  }

  // Return the value of blocked, open, or full magic numbers
  //
  private int blocked() { return ComponentStatuses.BLOCKED.ordinal(); }
  private int open() { return ComponentStatuses.OPEN.ordinal(); }
  private int full() { return ComponentStatuses.FULL.ordinal(); }
}
