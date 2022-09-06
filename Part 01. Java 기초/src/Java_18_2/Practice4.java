package Java_18_2;

public class Practice4 {
    public static String solution(int[] keyLog) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        StringBuffer sb = new StringBuffer();

        int step = (int) ('a' - 'A');

        int curSor = 0;
        int cmdIdx = 0;
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;

        while (cmdIdx != keyLog.length) {
            int cur = keyLog[cmdIdx];

            if (cur == BACK_SPACE) {
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1, curSor);
                curSor = Math.max(0, curSor - 1);
            } else if (cur == SHIFT) {  // 문자인지 숫자인지에 따라 구별
                isShift = true;
            } else if (cur == CAPS_LOCK) {  // 문자인지 숫자인지에 따라 구별
                isCapsLock = !isCapsLock;
            } else if (cur == SPACE_BAR) {
                inputData(sb, ' ', curSor, isInsert);
                curSor += 1;
            } else if (cur == KEY_LEFT) {
                curSor = Math.max(0, curSor - 1);
            } else if (cur == KEY_RIGHT) {
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur == INSERT) {
                isInsert = !isInsert;
            } else if (cur == DELETE) {  // 해당 자리에 있는 것을 삭제 /  BACK_SPACE는 이전 것을 삭제
                if(curSor == sb.length()) {   // 지울게 없음
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor, curSor + 1);   // 해당 커서 위치 삭제
            } else if (cur >= 97 && cur <= 122) {  // 알파벳
                int data = cur;

                if (isCapsLock && isShift) {  // CapsLock이 켜져있음 + Shift ->  소문자(그대로)
                    data = cur;
                } else if ( isCapsLock || isShift) {  // 둘중 하나 켜짐 -> 대문자
                    data -= step;
                }
                inputData(sb, (char)data, curSor, isInsert);
                isShift = false;  // Shift키 false로 초기화
                curSor += 1;
            } else if (cur >= 48 && cur <= 57) {  // 숫자
                if(isShift) {
                    char[] specialKey = {')', '!', '@', '#', '$', '%', '^', '&', '*', '('};
                    inputData(sb, specialKey[cur-'0'], curSor, isInsert);
                } else {
                    inputData(sb, (char)cur, curSor, isInsert);
                }

                // 데이터 입력

                isShift = false;
                curSor += 1;
            }

            cmdIdx++;
        }

        return sb.toString();
    }

    public static void inputData(StringBuffer sb, char data, int curSor, boolean isInsert) {
        if(isInsert == false) {
            sb.insert(curSor, data);
        } else {
            sb.setCharAt(curSor, data);
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97};
        System.out.println(solution(keyLog));

        keyLog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keyLog));
    }
}
