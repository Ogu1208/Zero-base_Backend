package Solution.Algorithm_08.src;// 거스름돈 문제

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void getChangeCoins(int receivedMoney, int price) {
        // 동전 종류
        final int[] coins = {500, 100, 50, 10, 5, 1};
        HashMap<Integer, Integer> result = new HashMap<>();

        // 잔돈
        int change = receivedMoney - price;
        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            // 동전 단위가 잔돈보다 크면 continue
            if (change < coins[i]) {
                continue;
            }

            // 해당 동전 개수
            int q = change / coins[i];
            result.put(coins[i], result.getOrDefault(coins[i], 0) + q);

            // 남은 잔돈
            change %= coins[i];
            // 거스름돈 동전 개수 업데이트
            cnt += q;
        }

        System.out.println("거스름돈 동전 개수: " + cnt);
        for (Map.Entry<Integer, Integer> cur: result.entrySet()) {
            System.out.println(cur.getKey() + ": " + cur.getValue());
        }
    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
