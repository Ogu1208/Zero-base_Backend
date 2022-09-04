Practice3
===

문제 설명
---
자바의 String 자료형에는 많은 연산자 기능들이 있다.

프로그래밍의 기본기를 익히기 위해 일부 연산자들을 제한하고 다음의 기능을 구현하려 한다.
- String 의 replace 기능 구현
- String의 replace, indexOf, contains를 사용하지 않고 구현한다.


입출력 예시
---
|입력 문자열|from|to|출력|
|---|---|---|---|
|"Hello Java, Nice to meet you! Java is fun!"|"Java"|"자바"|"Hello 자바, Nice to meet you! 자바 is fun!"|
|POP|P|W|WOW|


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
