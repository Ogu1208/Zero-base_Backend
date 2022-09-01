package Practice.Java_16.src;// Practice
// 아래 인터페이스를 이용하여 익명클래스로 구현한 내용을 람다식으로 구현해보세요.

interface CompareTool {
    public abstract int getMaxNum(int num1, int num2);
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        CompareTool cTool = new CompareTool() {
            @Override
            public int getMaxNum(int num1, int num2) {
                return num1 > num2? num1 : num2;
            }
        };
        System.out.println(cTool.getMaxNum(10, 11));


        // 람다식으로 작성

    }
}
