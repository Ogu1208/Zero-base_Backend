Practice2
===

문제 설명
---

주어진 nums 배열에서 두 번 나타나는 모든 정수의 배열을 반환하는 프로그램을 작성하세요.  
* nums 배열은 [1, n] 범위의 정수로 이루어져 있다.
* 각 정수는 한 번 또는 두 번 나타날 수 있다.


반환을 위한 메모리 공간 외에 추가 적인 배열 사용은 하지 않는다.


입출력 예시
---
|입력|출력|
|---|---|
|4, 3, 2, 7, 8, 2, 3, 1|2, 3|
|1, 1, 2|1|
|1, 3, 1, 3, 5, 5|1, 3, 5|

Solution
---
![18_3_2](https://user-images.githubusercontent.com/76902448/188638547-76dd9b59-131d-4720-bad1-a831425128a8.png)


<details>  
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : Math.abs(), 값을 index로 보기, 음수 </h4>


</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> iarr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                iarr.add(Math.abs(nums[i]));
            } else {
                nums[index] = - nums[index];
            }
        }
        return iarr;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}

  
```


</div>
</details>
