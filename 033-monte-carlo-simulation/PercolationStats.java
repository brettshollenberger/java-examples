import java.util.Random;

public class PercolationStats {
  static Random rand = new Random();

  public static void main(String[] argv) {
    int gridWidth    = StdIn.readInt();
    int numberTrials = StdIn.readInt();

    experiment(gridWidth, numberTrials);
  }

  private static void experiment(int gridWidth, int numberTrials) {
    double[] trials = new double[numberTrials];

    // StdOut.printf("%10s %10s \n", "n", "percent sites opened");

    for (int i = 0; i < numberTrials; i++) {
      double trial = runTrial(gridWidth);
      trials[i] = trial;

      // StdOut.printf("%10d %10f \n", i, trial);
    }

    StdOut.println();
    StdOut.printf("Trial Average: %f \n", trialAverage(trials));
  }

  private static double trialAverage(double[] trials) {
    double sum = 0;

    for (int i = 0; i < trials.length; i++) { sum += trials[i]; }

    return sum/trials.length;
  }

  private static double runTrial(int gridWidth) {
    Percolation perc    = new Percolation(gridWidth);
    int[] randomIndices = new int[gridWidth*gridWidth];

    for (int i = 0; i < gridWidth*gridWidth; i++) { randomIndices[i] = i; }

    KnuthShuffler.shuffle(randomIndices);

    for (int i = 0; !perc.percolates(); i++) { 
      perc.open(randomIndices[i]); 
    }

    return perc.percentSitesOpen();
  }
}
