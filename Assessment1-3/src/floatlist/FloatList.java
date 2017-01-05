package floatlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class FloatList extends ArrayList<MultiFloat> {
  public boolean add(LinkedList<Float> f) {
    return super.add(new MultiFloat(f));
  }

  public boolean add(Float f) {
    return super.add(new MultiFloat(f));
  }
}
