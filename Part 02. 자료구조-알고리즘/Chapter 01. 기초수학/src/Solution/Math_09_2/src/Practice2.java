package Solution.Math_09_2.src;

public class Practice2 {
    public static int solution(String str) {
        return isPalindrome(0, str.length() - 1, str.toCharArray(), 0);
    }

    public static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        while (left < right) {
            if (arr[left] != (arr[right])) {
                // 좌우 값이 동일하지 않은 경우 유사회문인지 아닌지 판단
                
                // 문자 한개 삭제 전이면
                if (delCnt == 0) {
                    // left 를 한칸 오른쪽 또는 right 를 한칸 왼쪽으로 이동 시켜 회문인지 판단
                    // 회문이면 유사회문 이므로 1 반환 아니면 2 반환
                    if (isPalindrome(left + 1, right, arr, 1) == 0 ||
                            isPalindrome(left, right - 1, arr, 1) == 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    // 문자 한개 삭제 후에 다시 이곳에 오면 2 반환
                    return 2;
                }
            } else {
                // 좌우가 같은 경우에는 left, right index 한 칸씩 이동
                left++;
                right--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        String[] str = {"abba", "summuus", "xabba", "xabbay", "comcom", "comwwmoc", "comwwtmoc"};
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
        System.out.println(solution("xabba"));
        System.out.println(solution("xabbay"));
        System.out.println(solution("comcom"));
        System.out.println(solution("comwwmoc"));
        System.out.println(solution("comwwtmoc"));
    }
}
