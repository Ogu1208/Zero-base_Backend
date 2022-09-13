public class Sam06 {
  public static void main(String[] args) {
    
    int iMax = 0x7f_ff_ff_ff + 1;
    int iMax2 = Integer.MAX_VALUE;

    int i1 = 0b0111_1111_1111_1111_1111_1111_1111_1111;
    int i2 = 0b1000_0000_0000_0000_0000_0000_0000_0000;
    int i3 = 0b0000_0000_0000_0000_0000_0000_0000_0000;

    System.out.println(iMax);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
  }
}
