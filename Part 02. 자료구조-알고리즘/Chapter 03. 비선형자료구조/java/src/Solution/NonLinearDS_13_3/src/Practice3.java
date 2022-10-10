package Solution.NonLinearDS_13_3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice3 {

    static class Customer {
        int id;
        int w;

        public Customer(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    static class Counter implements Comparable<Counter> {
        int no;
        int id;
        int time;

        public Counter(int no, int id, int time) {
            this.no = no;
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Counter o) {
            // 계산 먼저 끝나면 먼저 나감
            // 시간이 같으면 번호가 큰 계산대에서 먼저 나감
            if (this.time < o.time) {
                return -1;
            } else if (this.time == o.time) {
                if (this.no < o.no) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }
    }

    public static ArrayList<Integer> solution(int k, int[][] customers) {
        if (customers == null || customers.length == 0 || customers[0].length == 0) {
            return null;
        }

        int n = customers.length;

        // 계산 대기 중인 고객 관리 큐
        Queue<Customer> waitQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            waitQueue.offer(new Customer(customers[i][0], customers[i][1]));
        }
        
        // 계산대 우선순위 큐
        PriorityQueue<Counter> pqCounter = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            Customer customer = waitQueue.poll();
            
            // 기다리고 있는 고객이 있는 경우 추가
            if (customer != null) {
                pqCounter.offer(new Counter(i, customer.id, customer.w));
            }
        }

        // 계산이 끝난 카운터 (다음 손님 받을 수 있음)
        PriorityQueue<Integer> pqCounterDone = new PriorityQueue<>();

        int curTime = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(!pqCounter.isEmpty()) {
            Counter counter = pqCounter.poll();
            
            // 고객 나가는 순으로 저장
            result.add(counter.id);
            // 가장 먼저 계산하고 나가는 시간 기준 업데이트
            curTime = Math.max(curTime, counter.time);
            // 계산 끝난 카운터 쪽에 업데이트
            pqCounterDone.offer(counter.no);

            // 동시간대 계산 끝난 경우에 대한 처리
            while(!pqCounter.isEmpty()) {
                if (pqCounter.peek().time == curTime) {
                    Counter c = pqCounter.poll();
                    result.add(c.id);
                    pqCounterDone.offer(c.no);
                } else {
                    break;
                }
            }

            // 다음 기다리는 고객 계산대에 배치
            while(!pqCounterDone.isEmpty()) {
                Customer customer = waitQueue.poll();
                if (customer != null) {
                    // 기다리는 고객이 있는 경우 카운터에 배치
                    pqCounter.offer(new Counter(pqCounterDone.poll(), customer.id, curTime + customer.w));
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }
}
