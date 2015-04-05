public class Copier<Item> {
  public Stack<Item> copy(Stack<Item> input) {
    Stack<Item> intermediary = new Stack<Item>();
    Stack<Item> output = new Stack<Item>();

    for (Item i: input) {
      intermediary.push(i);
    }

    for (Item i: intermediary) {
      output.push(i);
    }

    return output;
  }
}
