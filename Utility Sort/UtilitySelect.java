//package SortingAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UtilitySelect {
    public static void main(String[] args) throws IOException {
        UtilitySelectOperation utilitySelectOperation = new UtilitySelectOperation();
        utilitySelectOperation.setNumberList();
        utilitySelectOperation.utilitysort();
        utilitySelectOperation.printResult();
    }
}

class UtilitySelectOperation{
    protected int medianValue;
    protected ArrayList<Integer> numberList = new ArrayList<>();
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();

    public void setNumberList() throws IOException {
        this.numberList = commonOperations.getNumberList();
    }

    public void utilitysort(){
        comparison.resetNumberOfComparisons();
        commonOperations.startTimer();

        Collections.sort(numberList,comparison);
        this.medianFind();

        commonOperations.stopTimer();
    }

    public void medianFind(){
        int length = numberList.size();
        int midInd = (int)Math.ceil(((float)length/2.0)-1);
        medianValue = numberList.get(midInd);
    }

    public void printResult(){
        System.out.println("median,"+medianValue);
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }
}
