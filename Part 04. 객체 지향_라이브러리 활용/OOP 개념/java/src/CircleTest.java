import java.util.Calendar;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        System.out.println("원의 넓이: " + c1.getArea());
        System.out.println("원의 둘레: " + c1.getPerimeter());

        Circle c2 = new Circle(100);
        System.out.println("원의 넓이: " + c1.getArea());
        System.out.println("원의 둘레: " + c1.getPerimeter());

        Calendar calendar = Calendar.getInstance(); // 싱글톤패턴 (new로 객체를 만들 수 없음)
    }
}
