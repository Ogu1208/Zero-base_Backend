public class Sam11 {
  public static void main(String[] args) {
    
    /* 
    int i1 = 12;
    int i2 = ~i1 + 1;

    System.out.println(i1);
    System.out.println(i2);
    */

    int i1 = 0b0000_0000_0000_0000_0000_0000_0001_0100;
    //       0b0000_0000_0000_0000_0000_0000_0000_1010

    System.out.println(i1);
    int i2 = i1 >> 1;
    System.out.println(i2);

  }
}
