package Solution.Java_18_2.src;

public class Practice2 {

    public static String solution(int num){
        String result = "";
        // 로마 숫자 표기 방법 규칙 적용 역순 나열
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;
        // 입력 num 이 0보다 큰 동안
        while (num > 0) {
            // 로마 숫자 표기 법 중 큰 수부터 현재 num 에서 뺄 수 있는지 체크
            while (num >= values[i]) {
                num -= values[i];
                result += roman[i];
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));
    }
}
