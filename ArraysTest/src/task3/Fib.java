package task3;

public class Fib {
  int length;
  int[] sequence;
  
  public Fib (int l) {
    this.length = l;
    this.sequence = calculate();
  }
  
  private int[] calculate() {
    int[] fib = new int[this.length];
    fib[0] = 0;
    fib[1] = 1;
    for(int i = 2; i < fib.length; i++) {
      fib[i] = fib[i-1] + fib[i-2];
    }
    return fib;
  }
  
  public void print() {
    for(int num : sequence) {
      System.out.print(num + " ");
    }
  }
}
