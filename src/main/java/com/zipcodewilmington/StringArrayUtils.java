package com.zipcodewilmington;

import java.util.ArrayList;
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
            reverseOrder[array.length - reverseCount] = s;
            reverseCount++;
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
        ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        ArrayList<char[]> newArray = new ArrayList<>();
        for (String s : array) {
            newArray.add(s.toCharArray());
        }
        for (char[] word : newArray){
            for (char letter : word) {
                if (alphabet.contains(letter)){
                    int index = alphabet.lastIndexOf(letter);
                    alphabet.remove(index);
                }
                else if (alphabet.contains(Character.toLowerCase(letter))) {
                    int index = alphabet.lastIndexOf(Character.toLowerCase(letter));
                    alphabet.remove(index);
                }
            }
        }
        return alphabet.size() == 0;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numberOfOccurences = 0;
        for (String s : array) {
            if (s == value){
                numberOfOccurences++;
            }
        }
        return numberOfOccurences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newValue = new ArrayList<>();
        for (String s : array){
            if (s != valueToRemove){
                newValue.add(s);
            }
        }
        String[] results = new String[newValue.size()];
        results = newValue.toArray(results);
        return results;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> results = new ArrayList<>();
        String first = "";
        for (String s : array) {
            if (s != first) {
                results.add(s);
                first = s;
            }
        }
        String[] removed = new String[results.size()];
        removed = results.toArray(removed);
        return removed;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
//    public static String[] packConsecutiveDuplicates(String[] array) {
//        ArrayList<String> results = new ArrayList<>();
//        String lastString = null;
//        String holder = "";
//        for(String s : array){
//            if (s != lastString){
//                if (holder == ""){
//                    holder = s;
//                }
//                else {
//                    results.add(holder);
//                    holder = s;
//                }
//            }
//            else {
//                holder += s;
//            }
//            lastString = s;
//        }
//        results.add(holder);
//        String[] removed = new String[results.size()];
//        removed = results.toArray(removed);
//        return removed;
//    }

    public static String[] packConsecutiveDuplicates(String[] array) {
        String[] buffer = new String[array.length];
        int i = 0;
        int j = 0;
        while (i < array.length) {
            String current = array[i];
            String prev = null;
            if (i == 0) {
                buffer[j] = current;
                i++;
                continue;
            } else {
                prev = array[i - 1];
                if (prev == current) {
                    buffer[j] += current;
                } else {
                    j++;
                    buffer[j] = current;
                }
            }
            i ++;
        }
        String[] output = Arrays.copyOfRange(buffer, 0, j+1);
        return output;
    }



}
