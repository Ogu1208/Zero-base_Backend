package Practice.Algorithm_11.src;// Practice1
// 정수형 배열 nums 가 주어졌다.
// 연속된 부분 배열의 합 중 가장 큰 값을 출력하세요.

// 입출력 예시
// nums: -5, 0, -3, 4, -1, 3, 1, -5, 8
// 출력: 10

// nums: 5, 4, 0, 7, 8
// 출력: 24

public class Practice1 {

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        return 0;
    }


    public static void main(String[] args) {
        // Test code
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution(nums));

        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(solution(nums));
    }
}
