package thisIsCodingTest.part3.binarySearch.searchLyrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchLyrics {
    private static int lowerBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int upperBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    private static final ArrayList<ArrayList<String>> arr = new ArrayList<>();
    private static final ArrayList<ArrayList<String>> reversedArr = new ArrayList<>();


    private static int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            reversedArr.add(new ArrayList<>());
        }

        for (String word : words) {
            arr.get(words.length).add(word);
            reversedArr.get(words.length).add(new StringBuffer(word).reverse().toString());
        }

        for (int i = 0; i < 100001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reversedArr.get(i));
        }

        for (String q : queries) {
            int res = 0;
            if (q.charAt(0) != '?') {
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            } else {
                res = countByRange(reversedArr.get(new StringBuffer(q).reverse().toString().length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            ans.add(res);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
    }
}