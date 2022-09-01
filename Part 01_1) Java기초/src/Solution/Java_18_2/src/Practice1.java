package Solution.Java_18_2.src;

import java.util.HashMap;

public class Practice1 {
    public static void solution(String s) {
        // 해시 맵으로 로마 숫자 표기 우선 초기화
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
            // 작은 표기가 앞에 온 경우 뺌
            if (map.get(arr[i]) < map.get(arr[i + 1])) {
                sum -= map.get(arr[i]);
            } else { // 일반 표기 순서의 경우 더함
                sum += map.get(arr[i]);
            }
        }
        sum += map.get(arr[arr.length - 1]);
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
