package practice.heap.moreSpicy;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 15;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (true) {
            if (2 > pq.size()) {
                answer = -1;
                break;
            }

            answer += 1;

            pq.add(pq.poll() + (pq.poll() * 2));

            if (pq.peek() > K) break;
        }

        return answer;
    }
}
