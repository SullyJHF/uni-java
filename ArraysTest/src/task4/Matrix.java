package task4;

public class Matrix {
  int[][] m;
  
  public Matrix(int[][] m) {
    this.m = m;
  }
  
  public void print() {
    for(int[] row : m) {
      for(int col : row) {
        System.out.print(col + "\t");
      }
      System.out.println();
    }
  }
  
  public int[][] transpose() {
    int[][] temp = new int[this.m[0].length][this.m.length];
    for(int i = 0; i < this.m.length; i++) {
      for(int j = 0; j < this.m[i].length; j++) {
        temp[i][j] = this.m[j][i];
      }
    }
    this.m = temp;
    return this.m;
  }
}
