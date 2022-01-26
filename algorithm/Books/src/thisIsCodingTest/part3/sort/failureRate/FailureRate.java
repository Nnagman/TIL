package thisIsCodingTest.part3.sort.failureRate;

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {
    private final int stage;
    private final double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public int compareTo(Node other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

public class FailureRate {
    private static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Node> arrayList = new ArrayList<>();
        int length = stages.length;
        int cnt;

        for (int i = 1; i < N; i++) {
            cnt = 0;
            for (int stage : stages) {
                if (stage == i) {
                    cnt += 1;
                }
            }

            double fail = 0;
            if (length >= 1) {
                fail = (double) cnt / length;
            }

            arrayList.add(new Node(i, fail));

        }

        Collections.sort(arrayList);

        for (int i = 0; i < N; i++) {
            answer[i] = arrayList.get(i).getStage();
        }

        return answer;
    }
}
