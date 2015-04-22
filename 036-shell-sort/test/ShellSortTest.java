import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import org.junit.*;
import org.junit.Test;

public class ShellSortTest {
  private Integer[] elements;

  @Before
  public void initialize() {
    elements = new Integer[]{5, 4, 3, 9, 1, 2, 0, 8, 7, 6};
  }

  @Test
  public void itSorts() {
    Integer[] sorted = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    ShellSort.sort(elements);

    assertEquals(sorted, elements);
  }
}
