package Solution.Java_18_2.src;

import java.util.ArrayList;

public class Practice3 {
    public static String solution(String input, String cmd) {
        // 문자열의 편집이 빈번할 때 유리한 StringBuffer 로 변환하여 사용
        StringBuffer sb = new StringBuffer(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        // 명령어들 분할하여 배열에 추가
        for (String s: cmd.split(" ")) {
            cmdArr.add(s);
        }

        // 초기 커서 위치
        int curSor = sb.length();
        // 명령어 배열의 인덱스로 사용할 변수
        int cmdIdx = 0;
        while (cmdIdx != cmdArr.size()) {
            String cur = cmdArr.get(cmdIdx);

            if (cur.equals("L")) {
                // 0일 때는 -1로 가지 않도록
                curSor = Math.max(0, curSor - 1);
            } else if (cur.equals("D")) {
                // 가장 맨 끝일 때는 그 이상 넘어가지 않도록
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur.equals("B")) {
                // 커서가 맨 앞일 때는 지울게 없으므로  continue
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                // 해당 위치의 문자 삭제 후 커서 재조정
                sb.delete(curSor - 1, curSor);
                curSor = Math.max(0, curSor - 1);
            } else if (cur.equals("P")) {
                String s = cmdArr.get(++cmdIdx);
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
