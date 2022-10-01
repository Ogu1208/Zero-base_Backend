public class 콜라 {

    private static final int 용량 = 20;   // 명시적 초기화
    private int 제조일자 = 10;

    static {  // static 키워드를 초기화 할 때때
        System.out.println(" 클래스 초기화 블럭");
//        용량 = 40;
//       제조일자 = 40;  // error
        System.out.println("용량: " + 용량);
//        System.out.println("제조일자: " + 제조일자);
    }

    {
        System.out.println(" 인스턴스 초기화 블럭");
        제조일자 = 50;
//        용량 = 50;
        System.out.println("용량: " + 용량);
        System.out.println("제조일자: " + 제조일자);
    }

    public 콜라() {
        System.out.println(" 생성자 호출 ");
//        용량 = 60;
        제조일자 = 60;
        System.out.println("용량: " + 용량);
        System.out.println("제조일자: " + 제조일자);
    }
}
