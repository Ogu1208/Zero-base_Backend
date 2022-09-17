import javax.sound.sampled.SourceDataLine;

public class Sam10 {
  public static void main(String[] args) {
    int i1 = 10;
    int i2 = 10;
    long i3 = 20;

    int j1 = 20;
    int j2 = 30;

    // boolean result1 = i2 == i3;
    // boolean result2 = i2 === i3;   // javascript에서 형이 같은지
  
    System.out.println(i1 > i2);
    System.out.println(i1 >= i2);
    System.out.println(i1 < i2);
    System.out.println(i1 <= i2);
    System.out.println(i1 == i2);
    System.out.println(i1 != i2);

    System.out.println("============");

    System.out.println((i1 < i2) && (j1 < j2));
    System.out.println((i1 < i2) || (j1 < j2));
    System.out.println((i1 < i2) ^ (j1 < j2));   // 다르면 true
    System.out.println(!(i1 < i2));
  }

}
