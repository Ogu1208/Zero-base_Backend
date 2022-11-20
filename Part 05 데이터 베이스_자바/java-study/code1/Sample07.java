package code1;

public class Sample07 {
  
  public static void main(String[] args) {
    
    for (int j = 1; j <= 9; j++) {
      for (int i = 1; i <= 9; i++) {
        System.out.printf("%d * %d = %d", j, i, (j * i));
        System.out.printf("\t");
      }
      System.out.println();
    }
    
  }
}
