public class Sample09 {
  public static void main(String[] args) {
    int i1 = 12 / 5;
    int i2 = 12 % 4;

    System.out.println(i1);
    System.out.println(i2);

    //증가 연산자 ++i;
    //감소 연산자 --i;
    //전위 연산자 ++i;
    //후위 연산자 i++;

    //전위증감 -> ++i;
    //후위감소 -> i--;

    int i21 = 10;
    
    System.out.println(i21);
    ++i21;
    System.out.println(i21);

    i21++;
    System.out.println(i21);

    System.out.println("--------------");

    System.out.println(++i21);
    System.out.println(i21++);

    System.out.println("--------------");

    System.out.println(i21);

    // 삼항연산자

    //(조건)      ? (참)        : (거짓);
    //(피연산자1) ? (피연산자2) : (피연산자3);

    int result = (3 > 4) ? 10 : 20;
    System.out.println("result: " + result);;
  }
}
