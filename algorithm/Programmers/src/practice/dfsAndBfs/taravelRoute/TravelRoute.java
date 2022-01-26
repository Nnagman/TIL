package practice.dfsAndBfs.taravelRoute;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

// 풀이출처 : https://tosuccess.tistory.com/36
public class TravelRoute {
    //방문한지 안한지를 체크하는 배열
    static boolean[] visited;
    static ArrayList<String> answers;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        // String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
        //String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        // 몇개의 공항을 들렸는지 알려주는 변수
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        // 답들 중 가장 알파벳순이 빠른 배열들로 정렬
        Collections.sort(answers);
        // 가장 빠른 배열을 뽑아서 String형 배열로 만듬
        return answers.get(0).split(" ");
    }

    public static void dfs(int count, String present, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answers.add(answer);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(present)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
