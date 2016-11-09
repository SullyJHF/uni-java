import java.util.Scanner;

public class SumSome {
  Scanner input = new Scanner(System.in);

  public void startSumming() {
    int num = 0;
    int total = 0;
    System.out.println("Enter some numbers you wish to be summed");
    while (num >= 0 && total <= 1024) {
      num = input.nextInt();
      total += num;
    }
    System.out.printf("The total of your numbers is %d%n", total);
  }
}
