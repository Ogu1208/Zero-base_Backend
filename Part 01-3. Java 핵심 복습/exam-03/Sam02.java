public class Sam02 {
  public static void main(String[] args) {
    // int j1 = 0b0000_0000_0000_0000_0000_0000_0000_0001;
    // int j2 = 0b0000_0000_0000_0000_0000_0000_0000_0001;   // i1에 대한 2의 보수
    // //       0b0000_0000_0000_0000_0000_0000_0000_0010
    // int j3 = j1 + j2;

    // System.out.println(j1);
    // System.out.println(j2);
    // System.out.println(j3);

    int i1   = 0b0000_0000_0000_0000_0000_0000_0000_1100;
    int i1_1 = 0b1111_1111_1111_1111_1111_1111_1111_0011;
    int i1_2 = i1_1 + 1;   // i1에대한 2의 보수 => i1에 대한 1의 보수 + 1;
    int i2   = 0b1111_1111_1111_1111_1111_1111_1111_0100;
    int i3   = 0b0000_0000_0000_0000_0000_0000_0000_0000;

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i1 + i2);
  }

}
