package aoc_2016.aoc_01;

import java.util.ArrayList;

public class Inputs extends ArrayList<Input> {

  public Inputs(String[] inputsAsArray) {
    for(String s : inputsAsArray) {
      Input input = new Input(s);
      add(input);
    }
  }

  public void printInputs() {
    for(Input i : this) {
      System.out.println(i.direction + " " + i.amount);
    }
  }
}
