//package SortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class CommonOperations {
    protected long starttime;
    protected long endtime;
    protected long timeElapsed;
    protected ArrayList<Integer>numberList = new ArrayList<>();
	public void resetNumberList(){
        numberList.clear();
    }
    public ArrayList<Integer> getNumberList() throws IOException {
	/*
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        while (scanner.hasNextLine()) {
            numberList.add(scanner.nextInt());
		}
		*/
		resetNumberList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputsize= Integer.parseInt(br.readLine());
		for (int i = 0; i<inputsize; i++)
			numberList.add(Integer.parseInt(br.readLine()));
		/*
        System.out.println("Enter the array list size: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        System.out.println("Choose the following options for input array:\n 1. Ascending\n2.Descending\n3.Random\n4.User input");
        int option = Integer.parseInt(br.readLine());
        switch (option){
            case 1:
                for(int i=1;i<=size;i++){
                    numberList.add(i);
                }
                break;
            case 2:
                for(int i=size;i>=1;i--){
                    numberList.add(i);
                }
                break;
            case 3:
                Random rand = new Random();
                    for(int i=0;i<size;i++){
                        numberList.add(rand.nextInt(size)+1);
                    }
                    break;
            case 4:
                for(int i=0;i<size;i++)
                    numberList.add(Integer.parseInt(br.readLine()));
            default:
                System.out.println("Please choose a proper option");
        }
		*/
        return numberList;
    }
    public void startTimer() {
        starttime = System.nanoTime();
    }
    public void stopTimer() {
        endtime = System.nanoTime();
    }
    public void printSortedList(ArrayList<Integer> sortedList) {
        for (int number : sortedList)
            System.out.println(number);
    }
    public void printResults(long numberOfComparisons) {
        this.timeElapsed = (endtime - starttime)/1000000;
        System.out.println("runtime,"+(long)(timeElapsed));
        System.out.println("comparisons," + (long) numberOfComparisons);
    }

    public long getTimeElapsed(){
        return this.timeElapsed;
    }
}
