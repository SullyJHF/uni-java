package floatlist;

import java.util.LinkedList;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // VARIABLE SETUP
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
    Float f1 = new Float(r.nextFloat());
    Float f2 = new Float(r.nextFloat());
    Float f3 = new Float(r.nextFloat());
    // VARIABLE SETUP END

    // Initialising the FloatList (ArrayList<MultiFloat>) and adding all the elements
    FloatList list = new FloatList();
    list.add(f1);
    list.add(floatList1);
    list.add(f2);
    list.add(floatList2);
    list.add(f3);

    for(int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
