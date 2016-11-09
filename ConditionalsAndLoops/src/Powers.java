import java.util.Scanner;

public class Powers {
  Scanner input = new Scanner(System.in);

  public void chooseNumber() {
    int num = 0;
    while (num <= 0) {
      System.out.print("Input a positive number to find the first 21 powers of: ");
      num = input.nextInt();
    }

    for (int i = 0; i <= 21; i++) {
      System.out.println(num + "^" + i + "= " + Math.pow(num, i));
    }
  }
}
