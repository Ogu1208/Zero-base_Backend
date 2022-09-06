Practice3
===

문제 설명
---

정렬된 정수형 배열 arr 이 주어졌을 때, 다음을 구하는 프로그램을 작성하세요.
* arr 과 함께 k 와 x 가 주어진다.
* k 는 개수, x 는 기준 값이다.
* x 와 절대 값 차이 기준으로 가까운 수를 k 개수 만큼 정렬된 순서로 출력하세요.
* 절대 값 차이가 같을 때는 숫자가 작은 것이 먼저 출력되도록 한다.


입출력 예시
---
|입력|k|x|출력|
|---|---|---|---|
|1, 2, 3, 4, 5|4|3|1, 2, 3, 4|
|1, 2, 3, 4, 5, 6, 7, 8, 9, 10|5|5|3, 4, 5, 6, 7|
|2, 4|1|3|2|
|2, 4|3|3|2, 4|


Solution
---
![18_3_3](https://user-images.githubusercontent.com/76902448/188659333-99a4ef46-07c6-41b0-9176-fb02041421c5.png)

참고 URL
- https://www.techiedelight.com/ko/find-k-closest-elements-to-given-value-array/

<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : HashMap, ArrayList </h4>



</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
  
  import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Practice3 {
    public static void solution(int[] arr, int k, int x) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(x - arr[i]);

            ArrayList<Integer> cur = map.get(diff);
            if (cur == null) {   // diff가 같은 경우가 아직 없는 경우
                map.put(diff, new ArrayList<>(Arrays.asList(arr[i])));

            } else { // diff가 같은 값이 있는 경우 작은값이 앞에 오도록 배치
                int idx = cur.size();  // 제일 크다면 마지막에 들어갈 수 있도록 초기화
                for (int j = 0; j < cur.size(); j++) {
                    if (cur.get(j) > arr[i]) {   // 꺼낸 값이 현재값보다 크다면
                        idx = j;   // 작은 숫자를 앞쪽에 배치
                        break;
                    }
                }
                cur.add(idx, arr[i]);  // arr[i]가 더 작다면 앞쪽에 추가
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;  // k개가 될 때 까지
        while (map.size() > 0) {   // k개만큼 출력해야 하는데 k개만큼 없을 수도 있으니까 size만큼 다 소진할 때 까지 반복
            int minDiff = map.keySet().stream().min((a, b) -> a - b).get();  // 가장 작은 값 추출
            // keySet들은 key값들이 쭉 나옴
            ArrayList<Integer> cur = map.get(minDiff);
            map.remove(minDiff);   // 꺼내 왔으므로 기존 map에서 minDiff에 해당하는 것 삭제

            while (cur.size() > 0) {
                result.add(cur.get(0));
                cur.remove(0);
                cnt++;   // k개가 될 때 까지

                if (cnt == k) {
                    break;
                }
            }

            if (cnt == k) {
                break;
            }
        }

        Collections.sort(result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}


```


</div>
</details>
