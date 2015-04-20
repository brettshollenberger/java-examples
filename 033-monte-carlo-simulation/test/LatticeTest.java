import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.*;
import org.junit.Test;

public class LatticeTest {
  private Lattice lattice;

  @Before
  public void initialize() {
    lattice = new Lattice(3);
  }

  @Test
  public void noComponentsInitiallyConnected() {
    assertEquals(lattice.connected(0, 1), false);
  }

  @Test
  public void openingOneComponentDoesNotConnect() { 
    lattice.open(0);
    assertEquals(lattice.connected(0, 1), false);
  }

  @Test
  public void openingConnectedComponents() {
    lattice.open(0);
    lattice.open(1);
    assertEquals(lattice.connected(0, 1), true);
  }

  @Test
  public void openingAcrossComponents() {
    lattice.open(0);
    lattice.open(2);
    assertEquals(lattice.connected(0, 2), false);
    lattice.open(1);
    assertEquals(lattice.connected(0, 2), true);
  }

  @Test
  public void openingAboveComponent() {
    assertEquals(lattice.connected(1, 4), false);

    lattice.open(1);
    lattice.open(4);

    assertEquals(lattice.connected(1, 4), true);
  }

  @Test
  public void openingBelowComponents() {
    assertEquals(lattice.connected(1, 4), false);

    lattice.open(4);
    lattice.open(1);

    assertEquals(lattice.connected(1, 4), true);
  }

  @Test
  public void openingManyComponents() {
    lattice.open(1);
    lattice.open(3);
    lattice.open(5);
    lattice.open(7);
    lattice.open(4);

    assertEquals(lattice.connected(1, 7), true);
    assertEquals(lattice.connected(1, 4), true);
    assertEquals(lattice.connected(1, 3), true);
    assertEquals(lattice.connected(1, 5), true);

    assertEquals(lattice.connected(3, 4), true);
    assertEquals(lattice.connected(3, 5), true);
    assertEquals(lattice.connected(3, 7), true);

    assertEquals(lattice.connected(4, 5), true);
    assertEquals(lattice.connected(4, 7), true);

    assertEquals(lattice.connected(5, 7), true);
    
    assertEquals(lattice.connected(0, 7), false);
  }

  @Test
  public void doesNotPercolateInitially() {
    assertEquals(lattice.percolates(), false);
  }

  @Test
  public void doesPercolateIfPathExistsFromTopToBottom() {
    lattice.open(0);
    lattice.open(3);
    lattice.open(6);

    assertEquals(lattice.percolates(), true);
  }
}
