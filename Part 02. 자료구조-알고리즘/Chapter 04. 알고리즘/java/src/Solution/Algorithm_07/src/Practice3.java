package Solution.Algorithm_07.src;// Practice
// 문자열 s 를 거꾸로 출력하는 프로그램을 작성하세요.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 s: "the sky is blue"
// 출력: "blue is sky the"

// 문자열 s: "  hello      java    "
// 출력: "java hello"


public class Practice3 {
    public static String solution(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() < 2) {
            return s;
        }

        // 문자열 사이 하나 공백을 제외한 나머지 공백 제거
        s = removeSpaces(s);

        char[] cArr = s.toCharArray();
        // 전체 문자열 뒤집기
        reverseString(cArr, 0, s.length() - 1);

        // 단어 단위 다시 뒤집기
        reverseWords(cArr, s.length());

        return new String(cArr);
    }

    public static String removeSpaces(String s) {
        int p1 = 0;
        int p2 = 0;

        char[] cArr = s.toCharArray();
        int length = s.length();

        while (p2 < length) {
            // 단어 앞 쪽 공백 skip
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            // 공백 아닌 경우 해당 문자로 채워넣기
            while (p2 < length && cArr[p2] != ' ') {
                cArr[p1++] = cArr[p2++];
            }

            // 단어 뒤쪽 공백 skip
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            // 단어와 단어 사이 공백 하나는 추가
            if (p2 < length) {
                cArr[p1++] = ' ';
            }
        }

        // 공백 정리해서 앞쪽부터 채워넣은 부분 문자열 반환
        return new String(cArr).substring(0, p1);
    }

    public static void reverseString(char[] cArr, int i, int j) {
        while (i < j) {
            char tmp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = tmp;
        }
    }

    public static void reverseWords(char[] cArr, int length) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < length) {
            // p1, p2 로 공백 제외 단어 부분 시작, 끝 설정
            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
                p1++;
            }
            
            while (p2 < p1 || p2 < length && cArr[p2] != ' ')  {
                p2++;
            }

            reverseString(cArr, p1, p2 - 1);
        }
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
