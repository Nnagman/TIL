package kakao;

import java.util.Arrays;

public class 양궁대회 {

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }

    static int max = 0;
    static int[] answer = {-1};
    static int[] score = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    static int[] solution(int n, int[] info) {

        int[] info2 = new int[info.length];

        dfs(0, 0, n, info2, info);

        return answer;
    }

    static void dfs(int idx, int cnt, int n, int[] info2, int[] info) {
        if (idx == 11) {
            return;
        }

        if (cnt == n) {
            getPoint(info2, info);
            return;
        }

        dfs(idx + 1, cnt, n, info2, info);
        info2[idx] += 1;
        dfs(idx, cnt + 1, n, info2, info);
        info2[idx] -= 1;
    }

    static void getPoint(int[] info2, int[] info) {
        int point1 = 0;
        int point2 = 0;
        int gap = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] != 0 || info2[i] != 0) {
                if (info2[i] > info[i]) {
                    point2 += score[i];
                } else {
                    point1 += score[i];
                }
            }
        }

        gap = point2 - point1;

        if (max == gap && max > 0) {
            point1 = 0;
            point2 = 0;
            boolean check = false;

            for (int i = 0; i < 11; i++) {
                point1 += score[i] * answer[i];
                point2 += score[i] * info2[i];
                if (answer[i] < info[i]) {
                    check = true;
                }
            }

            if (point2 < point1 || (point2 == point1 && true)) {
                for (int i = 0; i < 11; i++) {
                    answer[i] = info2[i];
                }
            }
        }

        if (max < gap) {
            answer = new int[11];
            for (int i = 0; i < 11; i++) {
                answer[i] = info2[i];
            }
            max = gap;
        }
    }
}
