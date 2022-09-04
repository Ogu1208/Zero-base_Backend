Practice5
===

문제 설명
---
n개의 데이터가 height 배열에 주어졌다.  
height 배열의 각각의 원소는 아래 그림과 같이 각 벽에 대한 높이를 의미한다.

이와 같이 높이 값들이 주어졌을 때,  
이 중에서 어떤 두 벽을 고르면 가장 많은 물을 담을 수 있는지를 확인하고  
그 때의 면적을 출력하세요.

![img_1](https://user-images.githubusercontent.com/76902448/188312800-6e735817-d327-4617-980c-d759e82e70e6.png)

입출력 예시
---
|입력|출력|
|---|---|
|1, 8, 6, 2, 5, 4, 8, 3, 7|49|
|5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2|26|



Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : max, min </h4>
가로 길이를 x축이 가장 넓은 것부터 시작해서 가운데로 줄여나간다. <br>
왼쪽, 오른쪽 높이를 비교하여 더 작은 높이의 막대를 가운데쪽으로 옮긴다.


</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
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

```


</div>
</details>
