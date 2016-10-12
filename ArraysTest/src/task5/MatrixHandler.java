package task5;

public class MatrixHandler {
  public int[][] multiply(int[][] a, int[][] b) {
    int[][] result = new int[a.length][b[0].length];
    b = transpose(b);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        int[] a0 = a[i];
        int[] b0 = b[j];
        result[i][j] = dotProduct(a0, b0);
      }
    }

    return result;
  }

  private int[][] transpose(int[][] a) {
    int[][] temp = new int[a[0].length][a.length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        temp[i][j] = a[j][i];
      }
    }
    return temp;
  }

  private int dotProduct(int[] a, int[] b) {
    int total = 0;
    for (int i = 0; i < a.length; i++) {
      int product = a[i] * b[i];
      // System.out.println(a[i] + " * " + b[i] + " = " + product);
      total += product;
    }
    // System.out.println("Total: " + total);
    // System.out.println();
    return total;
  }

  public void printMatrix(int[][] a) {
    for (int[] row : a) {
      for (int col : row) {
        System.out.print(col + "\t");
      }
      System.out.println();
    }
  }

  public void printArray(int[] a) {
    for (int col : a) {
      System.out.print(col + "\t");
    }
    System.out.println();
  }
}
