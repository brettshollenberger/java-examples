public class WeightedQuickUnionPathCompression {
  private int[] components;
  private int[] sizes;
  private int size;
  private int count;

  public WeightedQuickUnionPathCompression(int sz) {
    size       = sz;
    count      = size;
    components = new int[size];
    sizes      = new int[size];

    for (int i = 0; i < size; i++) { 
      components[i] = i;
      sizes[i]      = 1;
    }
  }

  public void union(int i, int j) {
    int isRoot = find(i);
    int jsRoot = find(j);

    if (isRoot != jsRoot) {
      int isSize = sizes[isRoot];
      int jsSize = sizes[jsRoot];

      if (isSize >= jsSize) {
        components[jsRoot] = isRoot;
        sizes[isRoot] += jsSize;
      } else {
        components[isRoot] = jsRoot;
        sizes[jsRoot] += isSize;
      }

      count -= 1;
    }
  }

  public int find(int i) {
    while (components[i] != i) { 
      components[i] = components[components[i]]; // path compression
      i = components[i]; 
    }
    return i;
  }

  public boolean connected(int i, int j) {
    return find(i) == find(j);
  }
}
