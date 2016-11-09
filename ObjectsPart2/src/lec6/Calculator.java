package lec6;

public class Calculator {
  int[] numbers;

  public Calculator(String[] args) {
    this.numbers = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      this.numbers[i] = Integer.valueOf(args[i]);
    }
  }

  public int sum() {
    int total = 0;
    for (int x : this.numbers) {
      total += x;
    }
    return total;
  }

  /** This takes the first argument and subtracts all the others in the array */
  public int difference() {
    int total = this.numbers[0];
    for (int x : this.numbers) {
      total -= x;
    }
    return total;
  }

  public int product() {
    int total = 1;
    for (int x : this.numbers) {
      total *= x;
    }
    return total;
  }

  public double quotient() {
    double total = this.numbers[0];
    for (int x : this.numbers) {
      total /= x;
    }
    return total;
  }
}
