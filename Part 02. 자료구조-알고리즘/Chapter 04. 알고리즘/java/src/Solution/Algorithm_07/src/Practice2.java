package Solution.Algorithm_07.src;// Practice
// nums1 과 nums2 두 배열이 주어졌을 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
// 결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

// 입출력 예시
// nums1: 1, 2, 2, 1
// nums2: 2, 2
// 출력: 2

// nums1: 4, 9, 5
// nums2: 9, 4, 9, 8, 4
// 출력: 4, 9 (or 9, 4)

import java.util.Arrays;
import java.util.HashSet;

public class Practice2 {
    public static int[] solution(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        
        // 우선 두 배열을 정렬
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        // 각 배열 범위 안에서 반복문
        while (p1 < nums1.length && p2 < nums2.length) {
            // nums1 쪽이 작으면 p1 증가
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                // nums2 쪽이 작으면 p2 증가
                p2++;
            } else {
                // 같으면 hash set 에 추가
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        // Hashset -> 배열
        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer n : set) {
            result[idx++] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
