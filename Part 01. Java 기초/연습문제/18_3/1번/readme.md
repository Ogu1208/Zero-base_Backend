Practice1
===

문제 설명
---

정수형 오름차순 데이터가 nums 라는 배열에 주어졌다.  
현재 배열 내에는 중복된 데이터들이 들어있을 수 있는데 해당 중복들을 제거하는 프로그램을 작성하세요.

이 때, 추가 배열을 사용하지 않고 중복 데이터들을 제거해야 하며  
nums 배열 하나 만 사용하여 중복 데이터를 제거 후  
정렬된 데이터를 출력하세요.


입출력 예시
---
|입력|출력|
|---|---|
|1, 1, 2|1, 2|
|0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4|0, 1, 2, 3, 4|



Solution
---
 ![18_3_1](https://user-images.githubusercontent.com/76902448/188623278-87f1aa28-15a0-47b9-b6fb-3df5ff5b97b7.png)

<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : idx </h4>
  굳이 cu1, cur2를 만들 필요 없고, idx변수 하나만 만들어서 foreach문으로 돌려가며 비교하면서 idx를 변경하면 된다. 

</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

강사님 풀이
------
``` java
public class Practice1 {
    public static void solution(int[] nums) {
        int idx = 1;
        for (int num: nums) {
            if (idx == 0 || num > nums[idx-1]) {
                nums[idx++] = num;
            }
        }

        System.out.print("[" + idx + "] ");
        for (int i = 0; i < idx; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}

```  
  
내풀이
------
``` java
  public class Practice1 {
    public static void solution(int[] nums) {
        int cur1 = 1;
        int cur2 = 1;

        while (cur2 < nums.length) {
            if(nums[cur2] > nums[cur2-1]) {
                nums[cur1] = nums[cur2];
                cur1++;
            }
            cur2++;
        }

        for (int i = 0; i < cur1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}

```


</div>
</details>
