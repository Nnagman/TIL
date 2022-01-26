package thisIsCodingTest.part3.greedy.eatingShowOfMuji;

import java.util.*;

class Food implements Comparable<Food> {
    int time;
    int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
}

public class EatingShowOfMuji {
    public static int Solution(int k, int[] food_times) {
        long food_sum = 0;

        for (int i : food_times) food_sum += i;

        if (food_sum <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        long len = food_times.length;

        for (int i = 0; i < len; i++) {
            pq.add(new Food(food_times[i], i + 1));
        }

        long sum_values = 0;
        long now;
        long previous = 0;

        while (sum_values + (pq.peek().time - previous) * len <= k) {
            now = pq.poll().time;
            sum_values = now - previous * len;
            len -= 1;
            previous = now;
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().idx);
        }

        result.sort(Comparator.comparingInt(o -> o));

        return result.get((int) ((k - sum_values) % len));
    }
}
