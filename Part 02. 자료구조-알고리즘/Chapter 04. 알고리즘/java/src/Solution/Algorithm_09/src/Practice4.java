package Solution.Algorithm_09.src;// Practice
// 원형 루트 상에 n 개의 주유소가 있다.
// 각 주유소의 가스 보유량은 gas 배열에 주어지고,
// 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

// 어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지
// 계산하는 프로그램을 작성하세요.

// 입출력 예시
// gas: 1, 2, 3, 4, 5
// cost: 3, 4, 5, 1, 2
// 출력: 3

// gas: 2, 3, 4
// cost: 3, 4, 3
// 출력: -1


public class Practice4 {
    public static int solution(int[] gas, int[] cost) {
        // 각 위치에서 출발할 때 gas 충전량 - cost 를 기록
        // 전체 계산을 했을 때 total 양이 0 보다 크면 가능 0 보다 작으면 불가능

        int curGas = 0;
        int totalGas = 0;
        int startPos = 0;

        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            if (curGas < 0) {
                startPos = i + 1;
                curGas = 0;
            }
        }
        return totalGas >= 0 ? startPos : -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
