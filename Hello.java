//
// S. Stefanovich
// 83898
//
//
import java.util.Scanner;

public class Hello {
  public static void main(String[] args) {
    // Declaring some variables for later.
    String name;
    int age;
    boolean excitement;
    String word;
    // New Scanner Object
    Scanner in = new Scanner(System.in);

    System.out.println("What is your name?");
    name = in.nextLine(); // Next line is stored into string name.
    System.out.println("Hello " + name + ", nice to meet you!");
    System.out.println("How old are you?");
    // Checking if input is Int type.
    if (!in.hasNextInt()) {
      word = in.next();
      System.err.println(word + " is not an integer.");
      return;
    }
    // Checking input range.
    age = in.nextInt(); // Next int is stored into age.
    if (age <= 0) {
      System.err.println("Age cannot be lower than 0!");
      return;
    }
    System.out.println("You were born in " + (2025 - age) + "/" + (2025 - age + 1) + "!");
    System.out.println("Are you excited to learn programming?");
    // Checking if input is Boolean.
    if (!in.hasNextBoolean()) {
      word = in.next();
      System.err.println(word + " is not a boolean. \nOnly valid inputs are \"true\" or \"false\"");
      return;
    }
    excitement = in.nextBoolean(); // Next boolean is stored into excitement.
    System.out.println(
        "Hello "
            + name
            + ", nice to meet you! You were born in "
            + (2025 - age)
            + "/"
            + (2025 - age + 1)
            + "! Your answer to whether you are excited to learn programming is: "
            + excitement);
  }
}
