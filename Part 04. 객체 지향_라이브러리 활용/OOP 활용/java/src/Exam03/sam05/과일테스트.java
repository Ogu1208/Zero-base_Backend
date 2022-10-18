package Exam03.sam05;

public class 과일테스트 {

    public static void 과일확인(과일 과일체크) {
        if (과일체크 instanceof 바나나) {
            System.out.println("바나나 입니다.");
        } else if (과일체크 instanceof 배) {
            System.out.println("배 입니다.");
        } else if (과일체크 instanceof 사과) {
            System.out.println("사과 입니다.");
        } else {
            System.out.println("바나나, 배, 사과가 아닙니다.");
        }
    }

    public static void main(String[] args) {
        과일 과일1 = new 과일();
        과일 과일2 = new 바나나();
        과일 과일3 = new 배();
        과일 과일4 = new 사과();

        과일[] 과일리스트 = {과일1, 과일2, 과일3, 과일4};

        for (int i = 0; i < 과일리스트.length; i++) {
            과일확인(과일리스트[i]);
        }


//        생선 생선1 = new 생선();
//        if (생선1 instanceof 과일) {  // 이미 상속관계가 없어서 error가 남
//            System.out.println("과일입니다.");
//        } else {
//            System.out.println("과일이 아닙니다.");
//        }
    }
}
