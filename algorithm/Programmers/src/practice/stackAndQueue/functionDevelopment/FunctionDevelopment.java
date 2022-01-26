package practice.stackAndQueue.functionDevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {96, 94};
        int[] speeds = {3, 3};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> progressList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressList.add((int) Math.ceil((float) (100 - progresses[i]) / speeds[i]));
        }

        System.out.println(progressList);

        while (progressList.size() != 0) {
            int cnt = 0;
            int number = progressList.get(0);
            for (Integer progress : progressList) {
                if (number >= progress) cnt += 1;
                else break;
            }
            answer.add(cnt);
            progressList = progressList.subList(cnt, progressList.size());
            System.out.println(number + " " + progressList + " " + answer);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
