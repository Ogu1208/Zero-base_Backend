package Practice.LinearDS_14_1.src;

import java.util.HashMap;
import java.util.Stack;

public class Practice4 {
    public static void solution(String str) {
        Stack<String> stack = new Stack<>();
        boolean checkFlag = true;

        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");

        for (String s : str.split("")) {
            if (map.containsKey(s)) {  // map의 key값과 비교 (좌측값들)
                stack.push(s);
            } else if (map.containsValue(s)) {
                if (stack.isEmpty()) {
                    checkFlag = false;
                    break;
                } else {
                    String cur = stack.pop();
                    if (!s.equals(map.get(cur))) {  // 서로 괄호가 맞지 않는 경우
                        checkFlag = false;
                        break;
                    }
                }
            }
        }

        if (checkFlag && stack.isEmpty()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
