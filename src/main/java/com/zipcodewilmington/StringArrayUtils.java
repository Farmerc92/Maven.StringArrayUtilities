package com.zipcodewilmington;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String s : array) {
            if (s == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseOrder = new String[array.length];
        int reverseCount = 1;
        for(String s : array){
            reverseOrder[array.length - reverseCount++] = s;
        }
        return reverseOrder;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return Arrays.equals(reverse(array), array);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] alphabetCount = new boolean[26];
        for (String s : array){
            String str = s.toLowerCase();
            for (int i = 0; i < str.length(); i++){
                if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                    alphabetCount[str.charAt(i) - 'a'] = true;
                }
            }
        }
        for (boolean b : alphabetCount){
            if (!b){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numberOfOccurrences = 0;
        for (String s : array) {
            if (s == value){
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove){
        String[] buffer = new String[array.length];
        int outputLength = 0;
        for (String s : array) {
            if (!s.equals(valueToRemove))
                buffer[outputLength++] = s;
        }
        String[] output = new String[outputLength];
        for(int i = 0; i < outputLength; i++){
            output[i] = buffer[i];
        }
        return output;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] buffer = new String[array.length];
        int outputLength = 0;
        for(int i = 0; i < array.length; i++){
            if (i == 0 || !array[i].equals(array[i-1])) {
                buffer[outputLength] = array[i];
                outputLength++;
            }
        }
        String[] output = new String[outputLength];
        for(int i = 0; i < outputLength; i++){
            output[i] = buffer[i];
        }
        return output;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String[] buffer = new String[array.length];
        String lastSeen = array[0];
        String stringToAdd = "";
        int outputLength = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i].equals(lastSeen))
                stringToAdd += lastSeen;
            else {
                buffer[outputLength++] = stringToAdd;
                System.out.println(stringToAdd);
                lastSeen = array[i];
                stringToAdd = array[i];
            }
        }
        buffer[outputLength++] = stringToAdd;
        String[] output = new String[outputLength];
        for(int i = 0; i < outputLength; i++){
            output[i] = buffer[i];
        }
        return output;
    }



}
