Practice3
===

문제 설명
---
간단한 편집기를 구현하려고 한다.

편집기에는 문자열과 편집 명령어가 주어지는데, 명령어의 동작은 다음과 같다.
- L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시)
- D	: 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시)
- B	: 커서 왼쪽에 있는 문자를 삭제 (커서가 문장의 맨 앞이면 무시)
- P x : x라는 문자를 커서 왼쪽에 추가

여기서 커서는 문자열에서 편집이 시작되는 기준 위치로,  
문장의 맨 앞, 맨 뒤, 중간에 위치할 수 있다.

편집기에 문자열과 명령어들이 주어졌을 때,  
편집을 완료한 후의 문자열을 출력하는 프로그램을 작성하시오.  
(초기 커서의 위치는 문장의 맨 뒤에서 시작한다.)  
(문자열은 소문자만 입력 가능하다.)


입출력 예시
---
|초기 문자열|명령어|결과 출력|
|---|---|---|
|"aba"|"L B"|"aa"|
|"abcd"|"P x L P y"|"abcdyx"|
|"abc"|"L L L P x L B P y"|"yxabc"|
|"a"|"B B L L D D P a P b P c"|"abc"|


Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : 아스키 모드, if문 </h4>

문자열이 빈번하게 바뀌기 때문에 StringBuffer를 이용한다.


</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java

import java.util.ArrayList;

public class Practice3 {
    public static String solution(String input, String cmd) {
        StringBuffer sb = new StringBuffer(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        for (String s : cmd.split(" ")) {   // 명령문을 split해서 cmdArr에 넣어줌
            cmdArr.add(s);
        }

        int curSor = sb.length();
        int cmdIdx = 0;
        while (cmdIdx != cmdArr.size()) {
            String cur = cmdArr.get(cmdIdx);

            if (cur.equals("L")) {
                curSor -= Math.max(0, curSor - 1);  // 커서가 0보다 작으면 안되니까
            } else if (cur.equals("D")) {
                curSor = Math.min(sb.length(), curSor + 1);   // 커서가 가장 끝이면 더 오른쪽으로 옮길 수 없음
            } else if (cur.equals("B")) {
                if (curSor == 0) {  // 지울게 없음
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1, curSor);  // 좌측 문자 삭제
                curSor = Math.max(0, curSor - 1);
            } else if (cur.equals("P")) { // 데이터를 하나 더 꺼내서 삽입함
                String s = cmdArr.get(++cmdIdx); // P x 면 x를 꺼내옴
                sb.insert(curSor, s);
                curSor += 1;
            }

            cmdIdx++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}


```


</div>
</details>
