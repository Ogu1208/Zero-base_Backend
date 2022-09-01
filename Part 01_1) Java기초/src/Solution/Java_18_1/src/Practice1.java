package Solution.Java_18_1.src;

public class Practice1 {
    public static void solution(int num) {
        int numReverse = 0;
        boolean isMinus = false;

        // 음수 체크하는 부분
        if (num < 0) {
            isMinus = true;
            num *= -1;
        }

        // 나머지 연산, 나누기 연산을 이용하여 거꾸로 변환하는 부분
        while (num > 0) {
            int r = num % 10;
            num /= 10;
            numReverse = numReverse * 10 + r;
        }

        System.out.println(isMinus ? numReverse * -1 : numReverse);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
