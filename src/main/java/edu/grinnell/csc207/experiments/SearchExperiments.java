package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Assorted experiments for searching structures.
 *
 * @author Myles Bohrer-Purnell
 * @author Yash Malikd
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  private static class Pred{
    static Predicate<String> lessThanFiveChars = new Predicate<String>() {
      public boolean test(String str) {
        if(str.length() < 5) {
          return true;
        } // if
        return false;
      } // test(String)
    };
  } // pred
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    String ex1c = SearchUtils.search(strings, Pred.lessThanFiveChars);
    pen.println(ex1c);

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.contains("u") == true);
      pen.println("The first string that contains a u is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings that contain a u.");
    } // try/catch

    pen.close();
  } // main(String[])
} // class SearchUtils
