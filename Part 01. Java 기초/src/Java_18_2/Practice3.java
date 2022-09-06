package Java_18_2;

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
