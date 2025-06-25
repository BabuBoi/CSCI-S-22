/*
 ***** THIS FILE IS FOR TESTING PURPOSES ONLY. *****
 * 
 * Put the final versions of your methods for problem 2 
 * in your ps1_partI file.
 * 
 * Do NOT submit them in this file.
 */

import java.util.*;    // for access to the Arrays class

public class Problem2Test {
    /*** Put your methods for problems 2a and 2b below ***/
    
    
    
 
    /*
     * This main method includes several tests for your methods.
     * 
     * It will not compile until you have added correct definitions
     * for both of the methods.
     * 
     * We encourage you to add additional tests as well.
     */ 
    public static void main(String[] args) {
        int[] values1 = {0, 2, 4, 6, 8, 10};
        int[] values2 = {0, 2, 4, 7, 8, 10};

        boolean ret1 = allEven(values1);
        System.out.println("allEven(values1) returns " + ret1);
        boolean ret2 = allEven(values2);
        System.out.println("allEven(values2) returns " + ret2);

        System.out.println("\nvalues1 array before shifting:");
        System.out.println(Arrays.toString(values1));
        shiftRight(values1);
        System.out.println("values1 array after shifting:");
        System.out.println(Arrays.toString(values1));
    }
}