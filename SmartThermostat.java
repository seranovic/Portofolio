/*
 S. Stefanovich
 83898

 Questions: Should I have used a switch on the decisionMaker method? It does not seem any cleaner than what I did.

 I hope my code is more readable now, I forgot to install a formatter when I did my previous assignment.
*/
import java.util.*;

public class SmartThermostat {
  // Declaring literals
  public static double DEADBAND = 1.0;
  public static int NIGHTSTART = 22;
  public static int NIGHTEND = 5;

  private static void decisionMaker(
      double targetTemp, double currentTemp, boolean windowOpen, int hour) {
    if (hour > NIGHTSTART || hour < NIGHTEND) {
      System.out.println("HOLD (energy saving)");
    } else if (windowOpen) {
      System.out.println("HOLD (energy saving)");
    } else if (targetTemp - DEADBAND <= currentTemp && targetTemp + DEADBAND >= currentTemp) {
      System.out.println("HOLD (within deadband)");
    } else if (currentTemp <= 5.0) {
      System.out.println("HEAT (freeze protection)");
    } else if (currentTemp + 1.0 <= targetTemp) {
      System.out.println("HEAT (below deadband)");
    } else if (currentTemp - 1.0 >= targetTemp) {
      System.out.println("COOL (above deadband)");
    }
  }

  public static void main() {
    // Declaring variables
    double targetTemp = 0.0;
    double currentTemp = 0.0;
    boolean windowOpen = false;
    int hour = 0;
    String word = "silly";

    // Initializing Scanner object
    Scanner in = new Scanner(System.in);

    // Checking current temperature.
    System.out.println("Current temperature(C\u00b0):");
    // Validating response
    if (!in.hasNextDouble()) {
      word = in.next();
      System.err.println(word + "is not a valid temperature.");
      return;
    }
    currentTemp = in.nextDouble();

    // Checking target temperature.
    System.out.println("Target Temperature (C\u00b0):");
    // Validating response
    if (!in.hasNextDouble()) {
      word = in.next();
      System.err.println(word + "is not a valid temperature.");
      return;
    }
    targetTemp = in.nextDouble();

    // Checking if window open.
    System.out.println("Is a window open? (true/false)");
    // Validating response
    if (!in.hasNextBoolean()) {
      word = in.next();
      System.err.println(word + "is not a valid answer (true/false)");
      return;
    }
    windowOpen = in.nextBoolean();

    // Checking time
    System.out.println("What is the current hour? (0-23)");
    // Validating that response was int.
    if (!in.hasNextInt()) {
      word = in.next();
      System.err.println(word + "is not a valid answer (0-23)");
      return;
    }
    // Validating that it is within range.
    hour = in.nextInt();
    if (hour < 0 || hour > 23) {
      System.err.println(hour + " is not a valid answer (0-23)");
      return;
    }
    System.out.println("-------------------\nDecision\n------------------");
    decisionMaker(targetTemp, currentTemp, windowOpen, hour);
  }
}
