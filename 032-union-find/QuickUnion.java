public class QuickUnion {
  private int[] components;
  private int totalComponents = 0;

  public QuickUnion(int n) {
    components      = new int[n];
    totalComponents = n;

    for (int i = 0; i < n; i++) { components[i] = i; }
  }

  // O(1) union - set components[q] to components[p]
  //
  public void union(int p, int q) {
    int psRoot = find(p);
    int qsRoot = find(q);

    if (psRoot == qsRoot) return;

    components[qsRoot] = components[psRoot];

    totalComponents -= 1;
  }

  // O(n) find
  public int find(int p) {
    while (p != components[p]) p = components[p];
    return p;
  }

  // O(n) connected 
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int count() {
    return totalComponents;
  }
}
