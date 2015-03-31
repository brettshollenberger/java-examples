public class LoiteringStack<Item> {
  private Item[] stack;
  private int N;

  public LoiteringStack(int cap) {
    stack = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(Item item) {
    if (N == stack.length) {
      resize(stack.length*2);
    } 

    stack[N++] = item;
  }

  // pop loiters because it does not set the reference to
  // stack[--N] to null: it still maintains a reference to the popped item
  public Item pop() {
    return stack[--N];
  }

  private void resize(int size) {
    Item[] tmp = (Item[]) new Object[size];

    for (int i = 0; i < N; i++) {
      tmp[i] = stack[i];
    }

    stack = tmp;
  }
}
