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
  public static int HOURS = 24; // Simpler to test program with less hours

  public static double minimum(double[] a) {
    /**
     * This method finds the minimum of a given double array.
     *
     * @param a: any array of type double
     */
    double min = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  public static double maximum(double[] a) {
    /**
     * This method finds the maximum of a given double array.
     *
     * @param a: any array of type double
     */
    double max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static double average(double[] a) {
    /**
     * This method finds the average of a given double array.
     *
     * @param a: any array of type double
     */
    double sum = 0.0;
    double average = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    average = sum / a.length;
    return average;
  }

  public static int unsafeHours(double[] a) {
    /**
     * This method finds the number of times an array is above a threshold UNHEALTHYQ.
     *
     * @param a: any array of type double
     */
    int hours = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > UNHEALTHYQ) {
        hours++;
      }
    }
    return hours;
  }

  public static void main(String[] Args) {
    // Declaring variables
    double[] aqByHour = new double[HOURS];
    String word = "silly";
    // Initializing scanner object.
    Scanner in = new Scanner(System.in);
    // Let user input data.
    for (int i = 0; i < HOURS; i++) {
      System.out.print("Hour " + i + ":\n");
      // Validate as double
      if (!in.hasNextDouble()) {
        word = in.next();
        System.err.print(word + " is not a valid AQ measurement\nTry again\n");
        i--; // avoids nested loop
      }
      aqByHour[i] = in.nextDouble();
      // Validate as positive.
      if (aqByHour[i] < 0) {
        System.err.print(aqByHour[i] + " is not a valid AQ measurement\nTry again\n");
        i--;
      }
    }
    System.out.print("-------------------------------------------------\n");
    System.out.print("AIR QUALITY STATISTICS\n");
    System.out.print("-------------------------------------------------\n");
    System.out.printf("Minimum: %.1f \n", minimum(aqByHour));
    System.out.printf("Maximum: %.1f \n", maximum(aqByHour));
    System.out.printf("Average: %.1f \n", average(aqByHour));
    System.out.printf("Number of unsafe hours: %d \n", unsafeHours(aqByHour));
    System.out.print("-------------------------------------------------\n");
  }
}
