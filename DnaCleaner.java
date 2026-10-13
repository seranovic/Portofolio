/*
 S. Stefanovich @seranovic
83898
*/

/** DNA cleaner. */
import java.util.*;

public class DnaCleaner {
  /** This method cleans a String DNA strand from pollutant */
  public static String cleanDNA(String dna, String pollutant) {
    if (dna.length()
        < pollutant
            .length()) { // if dna string is shorter than pollutant just return the dna string.
      return dna;
    }
    if (dna.substring(0, pollutant.length())
        .equals(pollutant)) { // if the substring matches pollutant return same method with the
      // pollutant cut
      return cleanDNA(dna.substring(2, dna.length()), pollutant);
    } else { // if nothing matches, move onto checking the next letter and concanate what was
             // already checked
      return dna.substring(0, 1) + cleanDNA(dna.substring(1, dna.length()), pollutant);
    }
  }

  public static void main(String[] args) {
    System.out.println(cleanDNA("ATXCGTXAGTX", "TX"));
    System.out.println(cleanDNA("TXTXTX", "TX"));
    System.out.println(cleanDNA("AGCTTXAGCT", "TX"));
  }
}
