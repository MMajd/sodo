package com.civil.sods.utility;

import java.util.stream.IntStream;

/**
 * Class Contain Utilities to be used
 *
 * @author Omnia Hussein
 * @author Esraa Salah
 * @author Abdullah Salama
 * @author Muhammad Abulmajd
 * @author Muhammad Medhat
 */
public class Utilities {

    /**
     * This function returns the index of the first element in the array which is equal to the value parameter. Returns
     * -1 if not found
     *
     * @param arr Array Of Elements
     * @param val Value Parameter
     *
     * @return Index of element
     */
    public static int indexOfElementInArray(int[] arr, int val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }

    /**
     * This function round the number to a precision after the dot of the double
     *
     * @param num Number
     * @param precision Precision that you want the number to
     *
     * @return Number as string
     */
    public static String fixedTo(double num, int precision) {
        int intNum = (int) num;

        double temp = Math.pow(10, precision);
        if (Math.round(num * temp) / temp == intNum) {
            return Integer.toString(intNum);
        }

        return Double.toString(Math.round(num * temp) / temp);
    }

    /**
     * Method that preform Quick Sort With Indices
     *
     * @param main Array of the main elements
     * @param index Array of Indices for the elements
     */
    public static void quickSortWithIndices(double[] main, int[] index) {
        quickSortWithIndices(main, index, 0, index.length - 1);
    }

    /**
     * quickSortWithIndices a[left] to a[right]
     *
     * @param a the array
     * @param index original indices of each element in the array
     * @param left start index of sub-array
     * @param right end index of sub-array
     */
    private static void quickSortWithIndices(double[] a, int[] index, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = partition(a, index, left, right);
        quickSortWithIndices(a, index, left, i - 1);
        quickSortWithIndices(a, index, i + 1, right);
    }

    /**
     * partition a[left] to a[right], assumes left < right
     *
     * @param a the array
     * @param index original indices of each element in the array
     * @param left start index of sub-array
     * @param right end index of sub-array
     *
     * @return the index in which two sub-arrays are to be divided
     */
    private static int partition(double[] a, int[] index, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (less(a[++i], a[right]));     // find item on left to swap a[right] acts as sentinel
            while (less(a[right], a[--j])) {    // find item on right to swap
                if (j == left) {
                    break;                      // don't go out-of-bounds
                }
            }
            if (i >= j) {
                break;                          // check if pointers cross
            }
            exch(a, index, i, j);               // swap two elements into place
        }
        exch(a, index, i, right);               // swap with partition element
        return i;
    }

    /**
     * is x < y ?
     *
     * @param x a double
     * @param y another double
     *
     * @return boolean answer
     */
    private static boolean less(double x, double y) {
        return (x < y);
    }

    /**
     * exchange a[i] and a[j]
     *
     * @param a the array
     * @param index original indices of each element in the array
     * @param i the index of element to be swapped
     * @param j the index of element to be swapped with
     */
    private static void exch(double[] a, int[] index, int i, int j) {
        double swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        int b = index[i];
        index[i] = index[j];
        index[j] = b;
    }

    /**
     * Private constructor to prevent creating an instance from the class
     *
     */
    private Utilities() {
    }
}
