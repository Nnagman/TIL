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

public class Solution {
    public static void main(String[] args) {
        solution(5, new int[]{3, 1, 2});
    }

    public static int solution(long k, int[] food_times) {
        long len = food_times.length;
        long food_sum = 0;

        for (int i = 0; i < len; i++) {
            food_sum += food_times[i];
        }

        if (food_sum <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long sum_values = 0;
        long previous = 0;
        long now;

        while (sum_values + ((pq.peek().time - previous) * len) <= k) {
            now = pq.poll().time;
            sum_values += (now - previous) * len;
            len -= 1;
            previous = now;
        }

        List<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        result.sort(Comparator.comparingInt(o -> o.idx));

        return result.get((int) ((k - sum_values) % len)).idx;
    }
}