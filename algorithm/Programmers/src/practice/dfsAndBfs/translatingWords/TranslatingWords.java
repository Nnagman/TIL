package practice.dfsAndBfs.translatingWords;

import java.util.Objects;

public class TranslatingWords {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"cog", "log", "lot", "dog", "hot"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean targetExist = false;

        for (String word : words) {
            if (Objects.equals(word, target)) {
                targetExist = true;
                break;
            }
        }

        if (targetExist) {
            answer = findWord(begin, words, target, 0);
        }

        return answer;
    }

    public static int findWord(String word, String[] words, String target, int moveCnt) {
        int similarIdx = 0;
        int similarCnt = 0;
        int targetSimilarCnt = getSimilarCount(target, word);

        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(word, words[i])) continue;
            int temp = getSimilarCount(words[i], word);
            if (temp > similarCnt) {
                similarIdx = i;
                similarCnt = temp;
            }
        }

        if (targetSimilarCnt == similarCnt) {
            return moveCnt + 1;
        }

        String[] slicedWords = new String[words.length - 1];
        int sliceWordsCnt = 0;

        for (String s : words) {
            if (!Objects.equals(words[similarIdx], s)) {
                slicedWords[sliceWordsCnt++] = s;
            }
        }

        return findWord(words[similarIdx], slicedWords, target, moveCnt) + 1;
    }

    public static int getSimilarCount(String word, String target) {
        int similarCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i))
                similarCnt += 1;
        }
        return similarCnt;
    }
}
