package task1;

class ArrayCalculator {
  int[] a;

  public ArrayCalculator(int[] a) {
    this.a = a;
  }

  public int min() {
    int smallest = Integer.MAX_VALUE;
    for (int value : this.a) {
      if (value < smallest) smallest = value;
    }
    return smallest;
  }

  public int max() {
    int largest = 0;
    for (int value : this.a) {
      if (value > largest) largest = value;
    }
    return largest;
  }

  public int range() {
    int start = min();
    int end = max();
    return Math.abs(end - start);
  }

  public int mean() {
    int total = 0;
    for (int value : this.a) {
      total += value;
    }
    return total / this.a.length;
  }

  public double sd() {
    int mean = mean();
    int varianceTotal = 0;
    for (int value : this.a) {
      varianceTotal += Math.pow((value - mean), 2);
    }
    int variance = varianceTotal / this.a.length;
    return Math.sqrt(variance);
  }
}
