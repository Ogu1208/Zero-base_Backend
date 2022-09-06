Practice4
===

문제 설명
---

MxN 행렬 정보가 2차원 정수형 배열 matrix 에 주어지면  
아래 그림과 같이 나선형 모양으로 출력하는 프로그램을 작성하세요.

![img_1.png](../imgs/img_1.png)

입출력 예시
---
|입력|출력|
|---|---|
|{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}|1, 2, 3, 6, 9, 8, 7, 4, 5|
|{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10 ,11 ,12}}|1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7|


Solution
---
![18_3_5](https://user-images.githubusercontent.com/76902448/188669375-32229f74-b73b-4a4f-be6a-5c081e8725f2.png)

<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : rowStart, rowEnd, colStart, colEnd </h4>
<h4> 🍑 그림 꼭 그려가면서 생각하기 🍑</h4>

colStart <= colEnd, rowStart <= rowEnd 인지 비교하기

 

</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
import java.util.ArrayList;

public class Practice4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) { // 첫줄 오른쪽 방향
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {   // colEnd 오른쪽 아랫방향
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {  // 마지막줄 왼쪽방향
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {   // 왼쪽 위로 올라가는 방향
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println((solution(matrix)));
    }
}

```


</div>
</details>
