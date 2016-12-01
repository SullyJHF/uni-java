package csv;

import java.util.ArrayList;

public class Statistics {
  public float min(ArrayList<Float> numbers) {
    float smallest = Integer.MAX_VALUE;
    for (float value : numbers) {
      if (value < smallest) smallest = value;
    }
    return smallest;
  }

  public float max(ArrayList<Float> numbers) {
    float largest = 0;
    for (float value : numbers) {
      if (value > largest) largest = value;
    }
    return largest;
  }

  public float range(ArrayList<Float> numbers) {
    float start = min(numbers);
    float end = max(numbers);
    return Math.abs(end - start);
  }

  public float mean(ArrayList<Float> numbers) {
    float total = 0;
    for (float value : numbers) {
      total += value;
    }
    return total / numbers.size();
  }

  public float sd(ArrayList<Float> numbers) {
    float mean = mean(numbers);
    int varianceTotal = 0;
    for (float value : numbers) {
      varianceTotal += Math.pow((value - mean), 2);
    }
    float variance = varianceTotal / numbers.size();
    return (float) Math.sqrt(variance);
  }
}
