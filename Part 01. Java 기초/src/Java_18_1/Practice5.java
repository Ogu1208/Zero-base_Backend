package Java_18_1;

public class Practice5 {
    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area = 0;
//      x축이 (가로 길이)가 가작 긴 것부터 줄여나가면서 구함
        while (left < right) {
            int x = (right - left);
            int y = height[left] < height[right] ? height[left] : height[right];
            int curArea = x * y;
            maxArea = maxArea > curArea ? maxArea : curArea;

//            curArea = x * Math.min(height[left], height[right]);
//            maxArea = Math.max(maxArea, curArea);

            if(height[left] < height[right]) {  // 더 큰 벽을 남겨놓고 계산할 수 있도록
                left++;   // left를 오른쪽으로 이동시킴
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
