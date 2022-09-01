package Practice.Java_07_2.src;// Practice
// 계산기 덧셈의 여러 타입 오버로딩

class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

}

public class Practice {
    public static void main(String[] args) {
        // Test code
        Calculator c = new Calculator();
        System.out.println(c.sum(1, 2));
//        System.out.println(c.sum(1.0, 2.0));
//        System.out.println(c.sum("1", "2"));
//        System.out.println(c.sum(1, 2, 3));
    }
}
