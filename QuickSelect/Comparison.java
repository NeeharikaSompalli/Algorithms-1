//package SortingAlgorithms;

import java.util.*;

public class Comparison implements Comparator<Integer> {
    private static long numberOfComparisons;
    @Override
    public int compare(Integer o1, Integer o2) {
        numberOfComparisons++;
        return o1.compareTo(o2);
    }
    public long getNumberOfComparisons(){
        return numberOfComparisons;
    }
    public void resetNumberOfComparisons(){
        numberOfComparisons = 0;
    }
}
