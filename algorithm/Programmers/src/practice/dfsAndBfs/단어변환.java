package practice.dfsAndBfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public static void main(String[] args) {
        String[] begin = {"hit", "hit"};
        String[] target = {"cog", "cog"};
        String[][] words = {{"hot", "dot", "dog", "lot", "log", "cog"},
            {"hot", "dot", "dog", "lot", "log"}};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(begin[i], target[i], words[i]));
        }
    }

    static class Node {

        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        int len = words.length;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.word.equals(target)) {
                return node.cnt;
            }

            for (int i = 0; i < len; i++) {
                if (!visited[i] && isNext(node.word, words[i])) {
                    q.add(new Node(words[i], node.cnt + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    static boolean isNext(String begin, String target) {
        int cnt = 0;
        int len = begin.length();
        for (int i = 0; i < len; i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                cnt += 1;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
