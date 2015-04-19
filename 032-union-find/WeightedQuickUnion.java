public class WeightedQuickUnion {
  private int[] components;
  private int[] sizes;
  private int sites;

  public WeightedQuickUnion(int size) {
    sites      = size;
    components = new int[size];
    sizes      = new int[size];

    for (int i = 0; i < size; i++) {
      components[i] = i;
      sizes[i]      = 1;
    }
  }

  public void union(int i, int j) {
    int isRoot = find_root(i);
    int jsRoot = find_root(j);

    if (isRoot != jsRoot) {
      if (sizes[isRoot] <= sizes[jsRoot]) {
        components[isRoot] = components[jsRoot];
        sizes[jsRoot] += sizes[isRoot];
      } else {
        components[jsRoot] = components[isRoot];
        sizes[isRoot] += sizes[jsRoot];
      }

      sites -= 1;
    }
  }

  public boolean connected(int i, int j) {
    return find_root(i) == find_root(j);
  }

  private int find_root(int i) {
    while (components[i] != i) { i = components[i]; }
    return i;
  }
}
