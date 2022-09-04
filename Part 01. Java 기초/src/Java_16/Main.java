package Java_16;
// Java 프로그래밍 - 람다식

interface ComputeTool {
    public abstract int compute(int x, int y);

    public abstract int compute2(int x, int y);
}



public class Main {

    public static void main(String[] args) {

        ComputeTool cTool1 = new ComputeTool() {
            @Override
            public int compute(int x, int y) {
                return x + y;
            }
            public int compute2(int x, int y) {
                return x - y;
            }
        };
        System.out.println(cTool1.compute(1, 2));


        // 람다식 - 2개 이상의 추상 메서드가 있을때는 사용이 제한된다.
//        ComputeTool cTool2 = (x, y) -> { return x + y; };
//        System.out.println(cTool1.compute(1, 2));

    }
}
