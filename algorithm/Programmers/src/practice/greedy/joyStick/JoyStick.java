package practice.greedy.joyStick;

import java.util.ArrayList;
import java.util.List;

public class JoyStick {
    public static void main(String[] args) {
        String name = "ABABAAAAAAABA";
        System.out.println(solution(name));
        System.out.println(solution2(name));
    }

    public static int solution(String name) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < name.length(); i++) {
            int c = name.charAt(i);

            if (c > 77) {
                c = 91 - c;
            } else {
                c = c - 65;
            }

            list.add(c);
        }

        int idx = 0;
        int move = 0;
        answer += list.get(0);
        list.set(0, 0);

        while (true) {
            move += 1;
            int n1 = idx + move > list.size() - 1 ? idx + move - list.size() : idx + move;
            int n2 = idx - move > -1 ? idx - move : list.size() - move;
            if (list.get(n1) > 0) {
                idx = n1;
                answer += list.get(n1) + move;
                list.set(n1, 0);
                move = 0;
            } else if (list.get(n2) > 0) {
                idx = n2;
                answer += list.get(n2) + move;
                list.set(n2, 0);
                move = 0;
            } else if (move + 1 == list.size()) {
                break;
            }
        }

        return answer;
    }

    public static int solution2(String name) {
        int answer = 0;
        int[] diff = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (char c : name.toCharArray())
            answer += diff[c - 'A'];

        int length = name.length();
        int min = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            min = Math.min(min, i + length - next + Math.min(i, length - next));
        }

        return answer + min;
    }
}
