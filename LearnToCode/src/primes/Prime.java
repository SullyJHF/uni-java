package primes;

public class Prime {
  public static void main(String[] args) {
    int count = 1000;
    double totalTime = 0;

    int numToTest = Integer.MAX_VALUE;

    for(int i = 0; i < count; i++) {
      long startTime = System.nanoTime();
      isPrimeOptimised(numToTest);
      totalTime += System.nanoTime() - startTime;
    }

    System.out.println(((totalTime / count) / 1000000.0) + " milliseconds");
  }

  public static boolean isPrime(int number) {
    if(number <= 1) return false;
    int divisor = 2;

    while (divisor < number) {
      if(number % divisor == 0) {
        return false;
      }
      divisor++;
    }

    return true;
  }

  public static boolean isPrimeOptimised(int number) {
    if(number <= 1) return false;
    int divisor = 2;

    while (divisor <= Math.sqrt(number)) {
//      if(divisor == 2 || divisor == 3) {
        if (testNumber(number, divisor)) {
          return false;
        }
//      }

      divisor++;
    }

    return true;
  }

  public static boolean testNumber(int number, int divisor) {
    return number % divisor == 0;
  }

  public static void listPrimes(int n) {
    int count = 0;
    int primeCount = 0;
    while(primeCount < n) {
      if(isPrimeOptimised(count)) {
        System.out.println(primeCount + 1 + ": " + count);
        primeCount++;
      }
      count++;
    }
  }
}
