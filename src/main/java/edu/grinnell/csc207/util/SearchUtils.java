package edu.grinnell.csc207.util;

import java.util.function.Predicate;

/**
 * Assorted utilities for searching structures.
 *
 * @author Myles Bohrer-Purnell
 * @author Yash Malik
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchUtils {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int iterativeBinarySearch(int[] vals, int val) throws Exception {
    int lb = 0;
    int ub = vals.length;
    int mid = 0;

    if (vals.length == 1) {
      if (vals[0] == val) return 0;
    } else {
      while (lb != ub) {
        mid = (lb + ub) / 2;
        if (val == vals[mid]) {
          return mid;
        } else if (val > vals[mid]) {
          lb = mid + 1;
        } else {
          ub = mid;
        } // if else
      }
    }
    throw new Exception(val + " is not in the array.");   
  } // iterativeBinarySearch

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int recursiveBinarySearch(int[] vals, int val) throws Exception {
    int lb = 0;
    int ub = vals.length;
    int mid = lb + (ub - lb) / 2;
    if (ub != lb) {
      int[] recArr = new int[vals.length / 2];
      if (vals[mid] == val) {
        return mid;
      } else if (vals[mid] > val) {
        for (int i = 0; i < mid; i++) {
          recArr[i] = vals[i];
        } // for
        return recursiveBinarySearch(recArr, val);
      } else {
        for (int i = 0; i < mid; i++) {
          recArr[i] = vals[mid+i+1];
        } // for
        return recursiveBinarySearch(recArr, val) + mid;
      } // else
    } else {
      if (vals[lb] == val) {
        return lb;
      } else {
        throw new Exception("The array is empty");
      } // else
    } // else
  } // recursiveBinarySearch

  /**
   * Search for val in a subarray of values, return the index of an 
   * instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param lb
   *   The lower bound of the area of interest (inclusive)
   * @param ub
   *   The upper bound of the area of interest (exclusive)
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i between lb and ub s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int rbsHelper(int[] vals, int lb, int ub, int val) throws Exception {
    return 0;   // STUB
  } // rbsHelper

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Search values for the first value for which pred holds.
   *
   * @param <T> 
   *   The type of values we're examining
   * @param values
   *   The iterable we're searching
   * @param pred
   *   The predicate used to determine whether or not the value is
   *   acceptable
   * 
   * @return the first mathcing element.
   *
   * @throws Exception
   *   If no matching value is found.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) throws Exception {
    for (T VAR : values) {
      if (pred.test(VAR) == true) {
        return VAR;
      } // if
    } // for
    throw new Exception("No matching value if found");
  } // search(Iterable<T>, Predicate<? super T>)

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  public static int binarySearch(int[] vals, int val) throws Exception {

    //return iterativeBinarySearch(vals, val);
    return recursiveBinarySearch(vals, val);
  } // binarySearch

} // class SearchUtils
