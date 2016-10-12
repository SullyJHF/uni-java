package task5;

public class Main {
  public static void main(String[] args) {
    int[][] a = { { 2, 3, 4 }, { 1, 0, 1 }, { 4, 3, 2 } };
    int[][] b = { { 5, 3, 5 }, { 1, 0, 1 }, { 3, 2, 3 } };
    MatrixHandler mh = new MatrixHandler();

    mh.printMatrix(mh.multiply(a, b));
  }
}
