package practice.stackAndQueue.truck;

import java.util.Queue;
import java.util.LinkedList;

public class Truck {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for (int truck : truck_weights)
            trucks.offer(truck);

        for (int i = 0; i < bridge_length; i++)
            bridge.offer(0);

        while (!trucks.isEmpty()) {
            int t = trucks.peek();
            w -= bridge.poll();
            if (weight > w + t - 1) {
                w += t;
                bridge.offer(t);
                trucks.remove();
            } else {
                bridge.offer(0);
            }
            answer += 1;
            System.out.println(bridge + "" + trucks + "" + answer + " " + w);
            System.out.println("==================================");
        }

        answer += bridge_length;

        return answer;
    }
}
