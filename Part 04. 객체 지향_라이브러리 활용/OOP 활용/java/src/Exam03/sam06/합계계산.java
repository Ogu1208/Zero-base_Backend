package Exam03.sam06;

public class 합계계산 {
    public int 더하기(int 값1, int 값2) {
        return 값1 + 값2;
    }

    public long 더하기(int 값1, int 값2, int 값3) {
        return 값1 + 값2 + 값3;
    }

    public long 더하기(int[] 값, int 값개수) {
        int sum = 0;
        for (int i = 0; i < 값개수; i++) {
            sum += 값[i];
        }

        return sum;
    }
}
