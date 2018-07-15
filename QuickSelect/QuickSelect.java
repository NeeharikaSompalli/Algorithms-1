//package SortingAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSelect {
    public static void main(String[] args) throws IOException{
        QuickSelectOperation quickSelectOperation = new QuickSelectOperation();
        quickSelectOperation.setNumberList();
        quickSelectOperation.quickSelectOperation();
        quickSelectOperation.printResult();

    }
}

class QuickSelectOperation{
    protected ArrayList<Integer> numberList = new ArrayList<>();
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();
    protected int medianValue;

    public void setNumberList() throws IOException {
        this.numberList = commonOperations.getNumberList();
    }

   public void quickSelectOperation(){
       int length = numberList.size();
       int midInd = (int)Math.ceil(((float)length/2.0)-1);
       commonOperations.startTimer();
       medianValue = medianFind(numberList.size(),midInd);
       commonOperations.stopTimer();
   }

    public int medianFind(int length,int n) {
        return iteration(0,length - 1, n);
    }

    public int iteration(int left, int right, int n) {
        if(left == right) {
            return numberList.get(left);
        }
        while(true) {
            int pivotIndex = 0;
            if((right-left)+1 >= 9)
            pivotIndex = pivotSelect(left, right);
            else pivotIndex = right;
            pivotIndex = split(left, right, pivotIndex);

            if(n == pivotIndex) {
                return numberList.get(n);
            } else if(n < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    public int split(int left, int right, int pivotIndex) {
        int pivotValue = numberList.get(pivotIndex);
        swap(pivotIndex, right);
        int storeIndex = left;
        for(int i = left; i < right; i++) {
            if(comparison.compare(numberList.get(i),pivotValue) <= 0) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }
        swap(right, storeIndex);
        return storeIndex;
    }

    public void swap(int a, int b) {
        int temp = numberList.get(a);
        numberList.set(a, numberList.get(b));
        numberList.set(b,temp);
    }

    public int pivotSelect(int left, int right) {
       int midIndex = left + (right-left)/2;
       int index = 0;
       int a = numberList.get(left);
       int b = numberList.get(midIndex);
       int c = numberList.get(right);
        int high = 0;
        int med = 0;
        if(comparison.compare(a, b) < 0){
            high = b;
            med= a;
        }else{
            med = b;
            high = a;
        }

        int median = 0;
        if(comparison.compare(high, c) < 0){
            median = high;
            //high = c;
        }
        else if(comparison.compare(med,c) < 0){
            median = med;
        }
        else median = c;

        //median = a + b + c - Math.min(a, Math.min(b,c)) - Math.max(a, Math.max(b,c));
       index = median == a?left:(median == b? midIndex: right);
/*
       List<Integer> findMedianList = new ArrayList<Integer>();
       findMedianList.add(a);
       findMedianList.add(b);
       findMedianList.add(c);
       //System.out.println(comparison.getNumberOfComparisons());
       Collections.sort(findMedianList,comparison);
       //System.out.println(comparison.getNumberOfComparisons());
       index = findMedianList.get(1).equals(a)?left:(findMedianList.get(1).equals(b)? midIndex: right);
       */
       return index;
    }

    public void printResult(){
        System.out.println("median,"+medianValue);
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }

}
