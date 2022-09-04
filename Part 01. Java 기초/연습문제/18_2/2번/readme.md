Practice2
===

문제 설명
---
정수형 숫자를 로마 숫자 표기로 변환하는 프로그램을 작성하세요.

로마 숫자 표기법은 I, V, X, L, C, D, M 으로 이루어져있다.

|로마 숫자|정수형|
|---|---|
|I|1|
|V|5|
|X|10|
|L|50|
|C|100|
|D|500|
|M|1000|


로마 숫자 표기 방식
* 큰 기호에서 작은 기호 방향으로 작성 (XI, VI, II, ...)
* 다음의 경우 작은 기호가 큰 기호 앞에 올 수 있다.
    * I 는 V 와 X 의 앞에 올 수 있다. (IV: 4, IX: 9)
    * X 는 L 과 C 의 앞에 올 수 있다. (XL: 40, XC: 90)
    * C 는 D 와 M 의 앞에 올 수 있다. (CD: 400, CM: 900)

입출력 예시
---

|입력|출력|
|---|---|
|3|"III"|
|4|"IV"|
|6|"VI"|
|13|"XIII"|
|26|"XXVI"|
|1994|"MCMXCIV"|


Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : 아스키 모드, if문 </h4>




</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
package Java_18_1;

import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 입력: ");
        char input = sc.nextLine().charAt(0);
        int output = 0;

        int step = (int) 'a' - 'A';

        if (input >= 'a' && input <= 'z') {
            output = (int) input - step;
            System.out.println("대문자 변환: " + (char) output);
        } else if (input >= 'A' && input <= 'Z') {
            output = (int) input + step;
            System.out.println("소문자 변환: " + (char) +output);
        } else {
            System.out.println("입력하신 값이 알파벳이 아닙니다.");
        }


    }

    public static void reference() {
        int a = (int) 'a';
        System.out.println("a = " + a);
        int z = (int) 'z';
        System.out.println("z = " + z);
        int A = (int) 'A';
        System.out.println("A = " + A);
        int Z = (int) 'Z';
        System.out.println("Z = " + Z);
        int etc = (int) '%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}



```


</div>
</details>
