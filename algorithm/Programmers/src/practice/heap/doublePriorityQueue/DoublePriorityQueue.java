package practice.heap.doublePriorityQueue;

import java.util.*;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        System.out.println(Arrays.toString(solutions(operations)));
    }

    public static int[] solutions(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            if (Objects.equals(operation, "D -1")) {
                if (!pq.isEmpty()) {
                    int polled = pq.poll();
                    rpq.remove(polled);
                }
            } else if (Objects.equals(operation, "D 1")) {
                if (!rpq.isEmpty()) {
                    int polled = rpq.poll();
                    pq.remove(polled);
                }
            } else {
                int n = Integer.parseInt(operation.substring(2));
                pq.add(n);
                rpq.add(n);
            }
        }

        if (pq.isEmpty() || rpq.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer[0] = rpq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }
}
