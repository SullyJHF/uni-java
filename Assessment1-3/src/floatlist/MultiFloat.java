package floatlist;

import java.util.LinkedList;

public class MultiFloat {
  private Object f;
  public MultiFloat(LinkedList<Float> l) {
    this.f = l;
  }

  public MultiFloat(Float f) {
    this.f = f;
  }

  public Object getMultiFloat() {
    return f;
  }

  @Override
  public String toString() {
    return f.toString();
  }
}
