/*
 S. Stefanovich
83898

Ideally all these methods should run at the same time so the array is only read once instead of 4x,
but for maintanibility reasons I have decided to split these up
*/
import java.util.*;

public class AirQualityTracker {
  // Declaring literals
  public static double GOODQ = 12.0; // Given in microgram per cubic meter
  public static double UNHEALTHYQ = 35.5;

  public static double minimum(double[] a) {
    return null;
  }

  public static double maximum(double[] a) {
    return null;
  }

  public static double average(double[] a) {
    return null;
  }

  public static int unsafeHours(double[] a) {
    return null;
  }

  public static void main() {
    // Declaring variables
    double[] aqByHour = new double[24];
    String word = "silly";
    // Initializing scanner object.
    Scanner in = new Scanner(System.in);
    // Let user input data.
    for (int i = 0; i < 24; i++) {
      System.out.print("Hour " + i + ":\n");
      // Validate as double
      if (!in.hasNextDouble()) {
        word = in.next();
        System.err.print(word + " is not a valid AQ measurement\nTry again\n");
        i--;
      }
      aqByHour[i] = in.nextDouble();
      // Validate as positive.
      if (aqByHour[i] < 0) {
        System.err.print(aqByHour[i] + " is not a valid AQ measurement\nTry again\n");
        i--;
      }
    }
  }
}
