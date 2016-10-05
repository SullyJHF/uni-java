import java.util.Scanner;

public class MinMax {
  Scanner input = new Scanner(System.in);

  public void startLoop() {
    int num = -1;
    int smallest = Integer.MAX_VALUE;
    int largest = 0;

    System.out.println("Enter the values you wish to find the min/max of and end with a -1:");

    do {
      num = input.nextInt();
      if (num == -1) break;
      if (num > largest) largest = num;
      if (num < smallest) smallest = num;
    } while (num != -1);

    System.out.printf("The largest value you inputted was: %d%n", largest);
    System.out.printf("The smallest value you inputted was: %d%n", smallest);
  }
}
