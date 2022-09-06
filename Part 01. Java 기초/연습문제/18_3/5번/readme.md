Practice5
===

문제 설명
---
n개의 정수형 데이터가 height 배열에 주어졌다.  
height 배열의 각각의 원소는 아래 그림과 같이 각 벽에 대한 높이를 의미한다.

이와 같이 높이 값들이 주어졌을 때,  
벽 사이사이의 빈 공간에 담을 수 있는 물의 총량을 출력하세요.
![img_2](https://user-images.githubusercontent.com/76902448/188674158-fa088c20-4e76-4244-a866-175e5a5bbdb8.png)


입출력 예시
---
|입력|출력|
|---|---|
|0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1|6|
|4, 2, 0, 3, 2, 5|9|


Solution
---
![18_3_5 (1)](https://user-images.githubusercontent.com/76902448/188677506-cb84d24a-8f5d-4158-8d25-1e7028392560.png)

<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : leftMax, rightMax </h4>

  양측에서 가운데로 더 작을때 가운데로 옮겨가면서 물의 높이는 Max와 비교한다.
 

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
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution(height));
    }
}


```


</div>
</details>
