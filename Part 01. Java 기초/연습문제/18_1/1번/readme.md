Practice1
===

문제 설명
---
입력된 정수 자료형의 숫자를 거꾸로 변환하는 프로그램을 작성하세요.

- 예를들어 12345가 입력되면 54321로 변환하여 출력하면 된다.
- 100의 경우 001이 되는데 이 경우 1만 출력하도록 한다.


입출력 예시
---
|입력|결과|
|---|---|
|12345|54321|
|-12345|-54321|
|100|1|
|0|0|

Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : 나머지 </h4>

ex) 
12345 % 10 -> 5
12345 / 10 -> 1234
![18_1_1](https://user-images.githubusercontent.com/76902448/188301184-f96c4503-13e1-4c44-9b7b-0b75ce8a2fa7.png)


</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
  package Java_18_1;

public class Practice1 {
    public static void solution(int num) {
        int numReverse = 0;
        boolean isMinus = false;

        if(num<0) {
            isMinus = true;
            num *= -1;
        }

        while(num > 0) {
            int r = num % 10;
            num /= 10;
            numReverse = numReverse * 10 + r;
        }
        System.out.println(isMinus ? numReverse * -1 : numReverse);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}

```


</div>
</details>
