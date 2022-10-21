package Solution.Algorithm_20_1.src;

public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }

        // 몇 번 접시를 얼마나 골랐는지 카운팅할 배열
        int[] selected = new int[types + 1];

        int cnt = 0;
        int max = 0;

        // 우선 처음부터 연속해서 골랐을 때 상태 업데이트
        for (int i = 0; i < n; i++) {
            if (selected[plates[i]] == 0) {
                cnt++;
            }
            selected[plates[i]]++;
        }
        max = cnt;

        for (int i = 1; i < plates.length; i++) {
            // 기존의 가장 많이 선택한 수보다 많이 선택되었으면,
            // 쿠폰 여부에 따라 추가
            if (max <= cnt) {
                if (selected[coupon] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            int p1 = i - 1;
            int p2 = (i + n - 1) % plates.length;

            // 앞 쪽에서 하나씩 선택 빼고 
            selected[plates[p1]]--;
            if (selected[plates[p1]] == 0) {
                cnt--;
            }
            
            // 뒤 쪽에서 하나씩 선택 추가
            if (selected[plates[p2]] == 0) {
                cnt++;
            }
            selected[plates[p2]]++;
        }

        return max;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
