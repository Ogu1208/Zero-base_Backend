
public class Sam07 {

  public static void main(String[] args) {
    // 문자형
    // 문자열 ->

    char c1 = '박';
    char c2 = '\ubc15';   // 유니코드
    char c3 = '\uaddc';   // 유니코드

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);

    char startValue = '\u0000';
    char endValue = '\uffff';
    char koStart = '\uac00';
    char koEnd = '\ud7af';
    for(int i = startValue; i <= endValue; i++) {
      if (i>=(int)koStart && i <= (int)koEnd) {
        char cc1 = (char)i;
        System.out.print(cc1);
      }
    }
  }
  

  
}
