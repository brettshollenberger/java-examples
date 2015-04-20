import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.*;
import org.junit.Test;

public class VerticalPercolationTest {
  private VerticalPercolation vp;

  @Before
  public void initialize() {
    vp = new VerticalPercolation(3);
  }

  @Test
  public void allSitesBlocked() {
    assertEquals(vp.status(0, 0), "BLOCKED");
  }
  
  @Test
  public void itOpensSites() { 
    vp.open(0, 0);
    assertEquals(vp.status(0, 0), "OPEN");
  }

  @Test
  public void itPercolatesIfAnEntireVerticalPathIsOpen() { 
    assertEquals(vp.percolates(), false);

    vp.open(0, 0);
    vp.open(0, 1);
    vp.open(0, 2);

    assertEquals(vp.percolates(), true);
  }
}
