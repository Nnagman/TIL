package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        int now, maxSize, minSize;

        for (int i = 0; i < N; i++) {
            now = Integer.parseInt(br.readLine());
            minSize = min.size();
            maxSize = max.size();

            if (minSize == maxSize) {
                if (minSize != 0 && now > min.peek()) {
                    max.add(min.poll());
                    min.add(now);
                } else {
                    max.add(now);
                }
            } else {
                if (maxSize != 0 && now < max.peek()) {
                    min.add(max.poll());
                    max.add(now);
                } else {
                    min.add(now);
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
