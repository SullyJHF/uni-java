package floatlist;

import java.util.LinkedList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    LinkedList<Float> floatList1 = new LinkedList<Float>();
    LinkedList<Float> floatList2 = new LinkedList<Float>();
    Random r = new Random();
    int size1 = r.nextInt(100);
    int size2 = r.nextInt(100);
    for(int i = 0; i < size1; i++) {
      floatList1.add(r.nextFloat());
    }
    for(int i = 0; i < size2; i++) {
      floatList2.add(r.nextFloat());
    }
  }
}
