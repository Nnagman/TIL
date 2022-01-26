package practice.hash.bestAlbum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    static public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        HashMap<String, Integer> playCounter = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> winnerRecorder = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            final String genre = genres[i];
            final int play = plays[i];

            if (playCounter.containsKey(genre)) playCounter.put(genre, playCounter.get(genre) + play);
            else playCounter.put(genre, play);

            // 장르별 2곡 선택해서 인덱스 기록
            if (winnerRecorder.containsKey(genre)) {
                final HashMap<String, Integer> genreWinner = winnerRecorder.get(genre);
                final int number1 = genreWinner.get("number1");
                final int number2 = genreWinner.get("number2");

                // play > number1 > number2
                if (play > number1) {
                    genreWinner.put("index2", genreWinner.get("index1"));
                    genreWinner.put("index1", i);
                    genreWinner.put("number2", number1);
                    genreWinner.put("number1", play);
                    winnerRecorder.put(genre, genreWinner);
                }

                // number1 >= play > number2
                if (number1 >= play && play > number2) {
                    genreWinner.put("index2", i);
                    genreWinner.put("number2", play);
                    winnerRecorder.put(genre, genreWinner);
                }
            } else {
                final HashMap<String, Integer> tempHashMap = new HashMap<>();
                tempHashMap.put("number1", play);
                tempHashMap.put("number2", -1);
                tempHashMap.put("index1", i);
                tempHashMap.put("index2", -1);
                winnerRecorder.put(genre, tempHashMap);
            }
        }

        final List<String> keys = new ArrayList<>(playCounter.keySet());
        keys.sort((o1, o2) -> playCounter.get(o2) - playCounter.get(o1));

        final List<Integer> answerList = new ArrayList<>();

        for (String key : keys) {
            final HashMap<String, Integer> genreWinner = winnerRecorder.get(key);

            if (genreWinner.get("number2") != -1) {
                answerList.add(genreWinner.get("index1"));
                answerList.add(genreWinner.get("index2"));
            } else
                answerList.add(genreWinner.get("index1"));
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;
    }
}
