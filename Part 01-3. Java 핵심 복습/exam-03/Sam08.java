public class Sam08 {
  public static void main(String[] args) {
    int i1 = 10;
    long l1 = 0x7fff_ffff_ffff_ffffL;
    long l2 = 20L;

    char c1 = ' ';
    char c2 = '\0';
    char c3 = '\u0000';   // NULL
    
    

    double d1 = 3.1E2;
    double d2 = 0x3.1P2;

    double d3 = Double.MAX_VALUE;
    System.out.println(d1);
    System.out.println(d2);
  }
}
