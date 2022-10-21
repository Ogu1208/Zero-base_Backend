package Solution.Algorithm_15.src;// Practice3
// sols 배열에 5지 선다 문제의 정답들이 적혀있다.
// 3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
// 문제를 찍어서 푼다고 할 때, 5점 이상을 받을 경우의 수를 출력하세요.

// 문제는 총 10문제이며 각 문제당 1점이다.

// 입출력 예시
// sols: {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}
// 결과: 261622


public class Practice3 {
    final static int numOfProblems = 10;
    static int cnt;

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        cnt = 0;
        int[] submit = new int[numOfProblems];
        backTracking(sols, submit, 0, 0);
        System.out.println(cnt);
    }

    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx) {
        // 나머지를 풀어도 5점 넘을 가능성이 없는 경우
        if (numOfProblems - idx + correctCnt < 5) {
            return;
        }

        if (idx == numOfProblems) {
            // 5점 이상인 경우 cnt 증가
            if (correctCnt >= 5) {
                cnt += 1;
            }
        } else {
            // 3 연속 같은 정답인 경우 없음
            int twoInaRow = 0;
            if (idx >= 2) {
                if (submit[idx - 1] == submit[idx - 2]) {
                    twoInaRow = submit[idx - 1];
                }
            }

            // 5지 선다 중 정답 하나씩 마킹하는 과정 backtracking
            for (int i = 1; i <= 5; i++) {
                if (i == twoInaRow) {
                    continue;
                }

                submit[idx] = i;
                
                // 정답, 오답에 따른 분기
                if (sols[idx] == i) {
                    backTracking(sols, submit, correctCnt + 1, idx + 1);
                } else {
                    backTracking(sols, submit, correctCnt, idx + 1);
                }
                submit[idx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] sols = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        solution(sols);

        sols = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        solution(sols);
    }
}
