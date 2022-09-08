package Solution.Math_09_2.src;

public class Practice5 {
    static StringBuffer sb;

    public static void solution(int n) {
        sb = new StringBuffer();
        // 원판 수, 시작 위치, 중간 위치, 끝 위치
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            // 원판 이동
            sb.append(start + " " + to + "\n");
            return;
        }

        // n-1 번 째 원판을 start -> mid 쪽으로 이동 재귀 호출
        // 결국 가장 위에 있는 원판 부터 이동 시작
        hanoi(n - 1, start, to, mid);

        // 위에서 원판 이동 후 다음 원판은 다른 위치로 이동
        sb.append(start + " " + to + "\n");

        // n-1 번 째 원판을 mid -> to 로 이동
        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) {
        // Test code
        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}
