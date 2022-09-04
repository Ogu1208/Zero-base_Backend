Practice4
===

문제 설명
---

여러가지 별찍기 연습을 해보자.  
반복문과 조건문의 연습에는 과연 별찍기 만한 것이 없다.

아래 5가지 별 찍기 타입이 있다.
- 아래 모양은 N (별 출력 행의 수)이 3일 떄의 출력 결과 들이다.

|타입|모양|
|---|---|
|1|*** <br> *** <br> ***|
|2|* <br> ** <br> ***|
|3|&nbsp;&nbsp;* <br> &nbsp;** <br> ***|
|4|&nbsp;&nbsp;* <br> &nbsp;*** <br> *****|
|5|&nbsp;&nbsp;* <br> &nbsp;*** <br> &nbsp;&nbsp;*|


별 출력 행의 수 N과 별 타입 T가 주어질 때 해당 별 모양을 출력하는 프로그램을 작성하세요.  
(N은 홀수)


입출력 예시
---
|N|T|출력|
|---|---|---|
|3|1|*** <br> *** <br> ***|
|3|2|* <br> ** <br> ***|
|3|3|&nbsp;&nbsp;* <br> &nbsp;** <br> ***|
|3|4|&nbsp;&nbsp;* <br> &nbsp;*** <br> *****|
|7|5|&nbsp;&nbsp;&nbsp;* <br> &nbsp;&nbsp;*** <br> &nbsp;***** <br> ******* <br> &nbsp;***** <br> &nbsp;&nbsp;*** <br> &nbsp;&nbsp;&nbsp;*|




Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : 반복문, /2, 5번같은 경우 반으로  </h4>




</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
package Java_18_1;

public class Practice4 {
    public static void solution(int n, int type) {
        switch (type) {
            case 1:
                type1(n);
                break;
            case 2:
                type2(n);
                break;
            case 3:
                type3(n);
                break;
            case 4:
                type4(n);
                break;
            case 5:
                type5(n);
                break;
        }

    }

    public static void type1(int n) {
        System.out.println("== Type1 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void type2(int n) {
        System.out.println("== Type2 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type3(int n) {
        System.out.println("== Type3 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type4(int n) {
        System.out.println("== Type4 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type5(int n) {
        System.out.println("== Type5 ==");
        // 상단부 - 한줄 더 출력 (가운데줄)
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 하단부
        for (int i = n / 2; i > 0; i--) {
            for (int j = 0; j < n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 1);
        solution(3, 2);
        solution(3, 3);
        solution(3, 4);
        solution(7, 5);
    }
}


```


</div>
</details>

