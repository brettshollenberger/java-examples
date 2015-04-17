public class QuickFind {
  private int[] components;
  private int totalComponents = 0;

  public QuickFind(int n) {
    components      = new int[n];
    totalComponents = n;

    for (int i = 0; i < n; i++) { components[i] = i; }
  }

  // O(n) union - set all objects in Q to P's component
  //
  public void union(int p, int q) {
    int psComponent     = find(p);
    int qsComponent     = find(q);

    if (psComponent != qsComponent) { 
      for (int i = 0, componentLength = components.length; i < componentLength; i++) {
        if (components[i] == qsComponent) {
          components[i] = psComponent;
        }
      }

      totalComponents -= 1;
    }
  }

  // O(1) find - single array access
  public int find(int p) {
    return components[p];
  }

  // O(1) connected - two array accesses
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int count() {
    return totalComponents;
  }
}
