package Solution.Java_18_2.src;

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

        int step = (int)('a' - 'A');

        int curSor = 0;
        int cmdIdx = 0;
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;
        while (cmdIdx != keyLog.length) {
            int cur = keyLog[cmdIdx];
            
            // backspace 는 이전과 동일
            if (cur == BACK_SPACE) {
                if (curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor - 1, curSor);
                curSor = Math.max(0, curSor - 1);
            } else if (cur == SHIFT) {  // shift 입력은 해당 변수 true 로 변경
                isShift = true;
            } else if (cur == CAPS_LOCK) {  // CapsLock 은 한 번 누르면 지속 (토글)
                isCapsLock = !isCapsLock;
            } else if (cur == SPACE_BAR) {
                inputData(sb, ' ', curSor, isInsert);   // 공백 문자 입력 후 커서 증가
                curSor += 1;
            } else if (cur == KEY_LEFT) {
                curSor = Math.max(0, curSor - 1);
            } else if (cur == KEY_RIGHT) {
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur == INSERT) { // Insert 는 한 번 누르면 지속 (토글)
                isInsert = !isInsert;
            } else if (cur == DELETE) { // Delete 는 backspace 와 커서 부분 살짝 다름
                if (curSor == sb.length()) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor, curSor + 1);
            } else if (cur >= 97 && cur <= 122) { // 알파벳 입력 부분
                int data = cur;
                // CapLock 켜진 상태에서 Shift 누르면 다시 소문자
                if (isCapsLock && isShift) {
                    data = cur;
                } else if (isCapsLock || isShift) { // 둘 중 하나가 true 면 대문자로 변경
                    data -= step;
                }
                inputData(sb, (char)data, curSor, isInsert);
                isShift = false;
                curSor += 1;
            } else if (cur >= 48 && cur <= 57) {
                if (isShift) {
                    // 각 숫자에 대응하는 특수문자 배열 (인덱스 0 부터 시작 -> ')')
                    char[] specialKey = {')', '!', '@', '#', '$', '%', '^', '&', '*', '('};
                    inputData(sb, specialKey[cur - '0'], curSor, isInsert);
                } else {
                    inputData(sb, (char)cur, curSor, isInsert);
                }
                isShift = false;
                curSor += 1;
            }

            cmdIdx++;
        }

        return sb.toString();
    }

    public static void inputData(StringBuffer sb, char data, int curSor, boolean isInsert) {
        // Insert 가 false 면 해당 위치에 삽입 true 면 해당 위치 변경
        if (isInsert == false) {
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
