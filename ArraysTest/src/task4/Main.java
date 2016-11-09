package task4;

public class Main {
  public static void main(String[] args) {
    int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
    Matrix m = new Matrix(array);
    m.print();
    System.out.println();
    m.transpose();
    m.print();
  }
}
