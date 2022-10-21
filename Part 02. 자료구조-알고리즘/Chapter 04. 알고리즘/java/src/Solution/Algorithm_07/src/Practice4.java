package Solution.Algorithm_07.src;// Practice
// 주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 set 은 제외하고 출력하세요.

// 입출력 예시
// nums: {-1, 0, 1, 2, -1, -4};
// 출력: [[-1, -1, 2], [-1, 0, 1]]

// nums: {1, -7, 6, 3, 5, 2}
// 출력: [[-7, 1, 6], [-7, 2, 5]]


import java.util.ArrayList;
import java.util.Arrays;

public class Practice4 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        // 오름차순 정렬
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // i 가 가리키는 값을 부호 반전 시킨 후
                // p1 과 p2 가 가리키는 값의 합이 i 가 가리키는 곳과 같은지 비교하는 방식
                int p1 = i + 1;
                int p2 = nums.length - 1;
                int sum = 0 - nums[i];

                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == sum) {
                        // 0 을 만족하는 경우 추가
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));

                        // 중복 피하기 위한 p1, p2 이동
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }
                        
                        // 한칸씩 이동
                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] < sum) {
                        p1++;
                    }
                    else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(solution(nums));
    }
}
