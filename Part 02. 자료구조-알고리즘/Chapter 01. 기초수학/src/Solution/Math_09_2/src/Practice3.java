package Solution.Math_09_2.src;

public class Practice3 {
    public static String solution(String equation) {
        String[] parts = equation.split("=");
        int[] leftSide = evaluate(parts[0]);
        int[] rightSide = evaluate(parts[1]);
//        int[] leftSide = evaluate2(parts[0]);
//        int[] rightSide = evaluate2(parts[1]);

        if (leftSide[0] == rightSide[0] && leftSide[1] == rightSide[1]) {
            return "Infinite solutions";
        } else if (leftSide[0] == rightSide[0]) {
            return "No solution";
        }
        return "x=" + (rightSide[1] - leftSide[1]) / (leftSide[0] - rightSide[0]);
    }

    public static int[] evaluate(String str) {
        // [0] 에는 x 의 계수, [1] 에는 상수항
        int[] result = new int[2];

        // # 1
        boolean isMinus = false;
        int idx = 0;
        while (idx != str.length()) {
            char c = str.charAt(idx++);

            if (c == '+') {
                continue;
            }

            if (c == '-') {
                isMinus = true;
                continue;
            }

            if (c == 'x') {
                // x 인 경우 부호에 따라 계수 쪽 업데이트
                result[0] += isMinus ? -1 : 1;
            } else {
                // 숫자인 경우
                // 그 다음이 x 인 경우 x 의 계수 부분 업데이트
                if (idx < str.length() && str.charAt(idx) == 'x') {
                    result[0] += isMinus ? -(c - '0') : (c - '0');
                    idx++;
                } else {
                    // 숫자만 있는 경우 상수항 업데이트
                    result[1] += isMinus ? -(c - '0') : (c - '0');
                }
            }
            isMinus = false;
        }

        return result;
    }

    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        int[] result = new int[2];

         // + 또는 -는 포함하여 파싱
        for (String s : str.split("(?=[+-])")) {
            if (s.equals("+x") || s.equals("x")) {
                result[0]++;
            } else if (s.equals("-x")) {
                result[0]--;
            } else if (s.contains("x")) {
                result[0] += Integer.parseInt(s.substring(0, s.length() - 1));
            } else {
                result[1] += Integer.parseInt(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solution(equation));

        equation = "x=x";
        System.out.println(solution(equation));

        equation = "2x=x";
        System.out.println(solution(equation));
    }
}
