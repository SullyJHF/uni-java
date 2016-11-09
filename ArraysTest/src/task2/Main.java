package task2;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    int[] die1 = {1, 2, 3, 4, 5, 6};
    int[] die2 = {1, 2, 3, 4, 5, 6};
    int[] totals = new int[36];
    int index = 0;
    for(int i = 0; i < die1.length; i++) {
      for(int j = 0; j < die2.length; j++) {
        System.out.print(die1[i] + die2[j] + " ");
        totals[index] = die1[i] + die2[j];
        index++;
      }
      System.out.println();
    }
    
    for(int total : totals) {
      System.out.println(total);
    }
    
    ArrayList<Integer> distinctTotals = new ArrayList<Integer>(12);
    for(int total : totals) {
      if(distinctTotals.contains(total)) continue;
      distinctTotals.add(total);
    }
    
    for(int n : distinctTotals) {
      System.out.print(n + " ");
    }
  }
}
