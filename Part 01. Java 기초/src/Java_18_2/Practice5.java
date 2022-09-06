package Java_18_2;

public class Practice5 {
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int result = 1;
        int upCnt = 1;
        int downCnt = 0;
        int peak = 0;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {  // 커지는 방향
                upCnt++;
                peak = upCnt;
                downCnt = 0;   // UP쪽으로 전환되면 Down을 다시 0으로 초기화
                result += upCnt;
            } else if (ratings[i] == ratings[i-1]) {  // 같은 경우
                upCnt = 1;
                downCnt = 0;
                peak = 0;
                result += 1;
            } else { // 작아지는 방향
                downCnt++;
                upCnt = 1;  // UpCnt 다시 1로 초기화
                result += downCnt;

                if (peak <= downCnt) {
                    result += 1;
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        // Test code
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
