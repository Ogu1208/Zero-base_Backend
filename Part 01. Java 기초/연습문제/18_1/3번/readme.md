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

<h4> 🍑 키워드 : 문자 배열(char), 문자열(String) </h4>

1. `findIndex(char[] str, char[] find)` 함수 <br>
반복문을 돌리면서 str에서 find의 첫번째 문자와 일치하는 idx가 있는지 찾는다. <br>
이때, str이 find보다 짧으면 더이상 비교할 필요가 없다.<br>
첫 문자가 같다면 나머지 문자들이 같은지 for문을 돌며 검사한다.
``` java
for (int j = 1; j < find.length; j++) {  // 첫 문자가 같으면 나머지 문자들이 같은 문자인지 비교
                    if (str[i + j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
```

나머지 문자들이 같다면 찾은 idx를 반환한다.

2. `solution(char[] str, char[] find, char[] to)` 함수 <br>
String 변수 replaceStr과, char[]형 변수 replaceBucket을 생성한다. <br>
`do-while`문을 돌며 문장 안의 모든 find를 to로 바꾼다. <br><br>
`do-while`문 <br>
앞의 `findIndex(char[] str, char[] find)`함수를 호출해 index를 반환받는다. <br>
만약 idx가 1이 아니라면 (찾는 문자가 있으면) <br>
- find전까지의 문자를 복사해 붙여 넣는다.
- find를 to로 바꾸어 붙여 넣는다.
- 이후의 나머지 문자들을 붙여 넣는다.

 






</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
package Java_18_1;

public class Practice3 {
    public static String solution(char[] str, char[] find, char[] to) {
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();

        do {
            idx = findIndex(replaceBucket, find);

            if (idx != -1) {
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceBucket[i];
                }

                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }

                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }

                replaceBucket = replaceStr.toCharArray();   // 첫번째 Java만 바뀌었으므로 두번쨰 Java를 찾기 위해서
                replaceStr = "";
            }

        } while (idx != -1);

        replaceStr = new String(replaceBucket);
        return replaceStr;

    }

    public static int findIndex(char[] str, char[] find) {
        int idx = -1;
        boolean isMatch = false;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == find[0] && str.length - 1 >= find.length) {
                isMatch = true;
                for (int j = 1; j < find.length; j++) {  // 첫 문자가 같으면 나머지 문자들이 같은 문자인지 비교
                    if (str[i + j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}


```


</div>
</details>
