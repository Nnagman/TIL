package practice.dfsAndBfs;

import java.util.Arrays;

public class 단어변환 {

    public static void main(String[] args) {
        String[] begin = {"hit", "hit"};
        String[] target = {"cog", "cog"};
        String[][] words = {
            {"hot", "dot", "dog", "lot", "log", "cog"},
            {"hot", "dot", "dog", "lot", "log"}
        };
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(begin[i], target[i], words[i]));
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;

        if(!Arrays.asList(words).contains(target)) {
            return answer;
        }



        return answer;
    }
}
