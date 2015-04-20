public class Lattice {
  private int[] components;
  private int[] componentSizes;
  private int size;

  public Lattice(int s) {
    size           = s;
    components     = new int[size*size];
    componentSizes = new int[size*size];

    for (int i = 0; i < (size*size); i++) { 
      components[i]     = sentinel();
      componentSizes[i] = 1;
    }
  }

  public boolean connected(int i, int j) {
    return find(i) == find(j);
  }

  public boolean percolates() {
    for (int i = 0; i < size; i++) {
      for (int j = ((size*size)-size); j < (size*size); j++) {
        if (connected(i, j)) {
          return true;
        }
      }
    }

    return false;
  }

  public void open(int i) {
    unblock(i);
    connectLeft(i);
    connectRight(i);
    connectUp(i);
    connectDown(i);
  }

  private int sentinel() {
    return -1;
  }

  private boolean isBlocked(int i) {
    return components[i] == sentinel();
  }

  private void unblock(int i) {
    if (isBlocked(i)) { components[i] = i; }
  }

  private void connectLeft(int i) {
    if (i % size != 0 && !isBlocked(i-1)) { union(i, i-1); }
  }

  private void connectUp(int i) {
    if (i >= size && !isBlocked(i-size)) { union(i, i-size); }
  }

  private void connectRight(int i) {
    int j = i;
    while (j >= size) { j -= size; }
    if (j != size-1 && !isBlocked(i+1))  { union(i, i+1); }
  }

  private void connectDown(int i) {
    if ((i + size) < (size*size) && !isBlocked(i+size)) { union(i, i+size); }
  }

  public int[] connections(int i) {
    int s = (int) Math.ceil(Math.sqrt(size*size));
    int[] c = new int[s];

    for (int q = 0; q < s; q++) { c[q] = -1; }

    int j = 0;

    while (components[i] != sentinel() && components[i] != i) {
      c[j++] = i = components[i];
    }

    return c;
  }

  private void union(int i, int j) {
    int isRoot = find(i);
    int jsRoot = find(j);

    if (isRoot != jsRoot) {
      if (componentSizes[isRoot] >= componentSizes[jsRoot]) {
        components[j] = find(i);
        componentSizes[i] += componentSizes[j];
      } else {
        components[i] = find(j);
        componentSizes[j] += componentSizes[i];
      }
    }
  }

  private int find(int i) {
    while (components[i] != sentinel() && components[i] != i) { i = components[i]; }
    return i;
  }
}
