Practice1
===

문제 설명
---
로마 숫자 표기를 정수형으로 변환하는 프로그램을 작성하세요.

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
|"III"|3|
|"IV"|4|
|"VI"|6|
|"XIII"|13|
|"XXVI"|26|
|"MCMXCIV"|1994|



Solution
---
<details>
<summary>Solution 보기</summary>
<div markdown="1">

<h4> 🍑 키워드 : 아스키 모드, if문 </h4>

앞의 문자, 뒤의 문자를 비교해서 뒤의 문자보다 크면 더하고, 작으면 뺀다. 

마지막 문자는 그냥 더한다.
 
ex) `MCMXCIV` : 1994
 
`M` 은 C보다 커서 더한다. 1000

`C`  M보다 작으니까 C(100)만큼  뺀다.   —- 1000 - 100 = **900**

`M`  X보다 크니까 1000을 더한다.   900 + 1000 = 1900

`X` C보다 작으니까 뺀다. 1900 - 10 = 1890

`C` I보다 크니까 더한다. 1890 + 100 - 1990

`I` V보다 작으니까 뺸다. 1990 - 1 = 1989

`V` 마지막 문자는 그냥 더한다. 1989 + 5 = 1994


</div>
</details>

Answer
---
<details>
<summary>정답 보기</summary>
<div markdown="1">

``` java
import java.util.HashMap;

public class Practice1 {
    public static void solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (map.get(arr[i]) < map.get(arr[i + 1])) {
                sum -= map.get(arr[i]);
            } else {
                sum += map.get(arr[i]);
            }
        }
        sum += map.get(arr[arr.length - 1]);   // 마지막 값 더해주기
        System.out.println(sum);

    }

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}


```


</div>
</details>
