import java.io.*;
import java.util.Random;
import org.kohsuke.args4j.*;

public class Generator {
  @Option(name="-n",usage="number of components to generate")
  private int num = 0;
  private Random rand = new Random();

  public static void main(String[] argv) {
    new Generator().doMain(argv);
  } 

  public void doMain(String[] argv) {
    CmdLineParser parser = new CmdLineParser(this);

    try {
      parser.parseArgument(argv);
    } catch(CmdLineException e) {
      System.err.println(e.getMessage());
    }

    if (num == 0) { return; }

    writeFile(String.format("uf_%d.connected", num), generateConnectionsString());
    writeFile(String.format("uf_%d.union", num), generateConnectionsString());
  }

  private String generateConnectionsString() {
    String[] strings = new String[num+1];
    strings[0]       = String.format("%d\n", num);

    for (int i = 1; i < num+1; i++) {
      int a = generateRandom();
      int b = generateRandom();

      strings[i] = String.format("%d %d\n", a, b);
    }

    StringBuilder output = new StringBuilder();

    for (String string : strings) {
      output.append(string);
    }

    return output.toString();
  }

  private void writeFile(String filename, String contents) {
    try {
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(filename), "utf-8"));
      writer.write(contents);
      try {
        writer.close();
      } catch (Exception ex) {}
    } catch (IOException ex) {
      StdOut.printf("File not found");
    } 
  }

  private int generateRandom() {
    return rand.nextInt(num);
  }
}
