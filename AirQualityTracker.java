/*
 S. Stefanovich @seranovic
83898

Ideally all these methods should run at the same time so the array is only read once instead of 4x,
but for maintanibility reasons I have decided to split these up
*/

/** Air quality tracker. */
import java.util.*;

public class AirQualityTracker {
  // Declaring literals
  public static double GOODQ = 12.0; // Given in microgram per cubic meter
  public static double UNHEALTHYQ = 35.5;
  public static int HOURS = 3; // Simpler to test program with less hours

  /**
   * This method finds the minimum of a given double array.
   *
   * @param a: any array of type double
   */
  public static double minimum(double[] a) {
    double min = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  /**
   * This method finds the maximum of a given double array.
   *
   * @param a: any array of type double
   */
  public static double maximum(double[] a) {
    double max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  /**
   * This method finds the average of a given double array.
   *
   * @param a: any array of type double
   */
  public static double average(double[] a) {
    double sum = 0.0;
    double average = 0.0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    average = sum / a.length;
    return average;
  }

  /**
   * This method finds the number of times an array is above a threshold UNHEALTHYQ.
   *
   * @param a: any array of type double
   */
  public static int unsafeHours(double[] a) {
    int hours = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > UNHEALTHYQ) {
        hours++;
      }
    }
    return hours;
  }

  /**
   * This method returns a string that states if the average of an array represents GOOD, UNHEALTHY
   * or AVERAGE air quality
   *
   * @param a: any array of type double
   */
  public static String overallAq(double[] a) {
    if (average(a) < GOODQ) {
      return "GOOD\n";
    }
    if (UNHEALTHYQ > average(a) || average(a) > GOODQ) {
      return "AVERAGE\n";
    }
    if (average(a) > UNHEALTHYQ) {
      return "UNHEALTHY\n";
    }
    return "";
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
    System.out.printf("Minimum: %.1f μg/m^3\n", minimum(aqByHour));
    System.out.printf("Maximum: %.1f μg/m^3\n", maximum(aqByHour));
    System.out.printf("Average: %.1f μg/m^3\n", average(aqByHour));
    System.out.printf("Hours above safe limit (35.5 μg/m^3): %d \n", unsafeHours(aqByHour));
    System.out.printf("Overall air quality: %s", overallAq(aqByHour));
    System.out.print("-------------------------------------------------\n");
  }
}
