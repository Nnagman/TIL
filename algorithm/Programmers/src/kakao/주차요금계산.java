package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 주차요금계산 {

    public static void main(String[] args) {
        int[][] fees = {{120, 0, 60, 591}};

        String[][] records = {
            {"16:00 0010 IN", "23:00 0100 IN"}};

        for (int i = 0; i < fees.length; i++) {
            System.out.println(Arrays.toString(solution(fees[i], records[i])));
        }
    }

    static public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> hs = new HashMap<>();
        boolean[] visited = new boolean[records.length];
        String[] temp, in, out;
        Stack<String> stack;
        String carNum;
        int hour, minute;

        for (int i = 0; i < records.length; i++) {
            if (!visited[i]) {
                temp = records[i].split(" ");
                carNum = temp[1];
                stack = new Stack<>();
                hs.put(carNum, 0);
                visited[i] = true;

                for (int j = i; j < records.length; j++) {
                    temp = records[j].split(" ");
                    if (temp[1].equals(carNum)) {
                        visited[j] = true;
                        if (temp[2].equals("IN")) {
                            stack.push(temp[0]);
                        } else {
                            in = stack.pop().split(":");
                            out = temp[0].split(":");
                            hour = (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60;
                            minute = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                            hs.put(carNum, hs.get(carNum) + hour + minute);
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    in = stack.pop().split(":");
                    out = "23:59".split(":");
                    hour = (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60;
                    minute = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                    hs.put(carNum, hs.get(carNum) + hour + minute);
                }
            }
        }

        List<String> cars = new ArrayList<>(hs.keySet());
        cars.sort(Comparator.comparingInt(Integer::parseInt));

        List<Integer> ans = new ArrayList<>();
        int fee;

        for (String num : cars) {
            minute = hs.get(num);
            fee = fees[1];
            if (minute > fees[0]) {
                if (minute % fees[2] != 0) {
                    minute -= minute % fees[2];
                    minute += fees[2];
                }
                fee += fees[3] * ((minute - fees[0]) / fees[2]);
            }
            ans.add(fee);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
