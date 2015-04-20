import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PercolationTest {
  private Percolation perc;

  @Before
  public void initialize() {
    perc = new Percolation(5);
  }

  @Test
  public void allSitesBlocked() {
    assertEquals("BLOCKED", perc.status(0, 0));
  }
  
  @Test
  public void itOpensSites() { 
    perc.open(0, 0);
    assertEquals("FULL", perc.status(0, 0));
  }

  @Test
  public void itTracksNeighbors() { 
    int[] n = perc.find(1, 1).neighbors;
    List<Integer> neighbors = new ArrayList<Integer>();
    for (int index = 0; index < n.length; index++) { neighbors.add(n[index]); }

    org.junit.Assert.assertThat(
        neighbors,
        hasItems(1, 5, 7, 11)
    );
  }

  @Test
  public void itTracksOpenComponents() {
    assertEquals(false, perc.connected(0, 10));

    perc.open(0, 0);
    perc.open(0, 1);
    perc.open(0, 2);

    assertEquals(true, perc.connected(0, 10));
  }

  @Test
  public void itEvaluatesCellReachabilityOnOpen() {
    assertEquals(false, perc.reachable(0, 2));

    perc.open(0, 2);

    assertEquals(false, perc.reachable(0, 2)); // 0, 2 not connected to top

    perc.open(0, 1);

    assertEquals(false, perc.reachable(0, 2)); // still not connected to top

    perc.open(0, 0);

    assertEquals(true, perc.reachable(0, 2)); // finally connected to a site that is open on top
  }

  @Test
  public void itPercolatesIfPathIsOpen() {
    assertEquals(false, perc.percolates());

    perc.open(12);

    assertEquals(false, perc.percolates());

    perc.open(7);

    assertEquals(false, perc.percolates());

    perc.open(6);

    assertEquals(false, perc.percolates());

    perc.open(13);

    assertEquals(false, perc.percolates());

    perc.open(18);

    assertEquals(false, perc.percolates());

    perc.open(19);

    assertEquals(false, perc.percolates());

    perc.open(24);

    assertEquals(false, perc.percolates());

    perc.open(5);

    assertEquals(false, perc.percolates());

    perc.open(0);

    assertEquals(true, perc.percolates());
  }
}
