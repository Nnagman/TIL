package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 주차요금계산 {

    public static void main(String[] args) {
        int[][] fees = {{180, 5000, 10, 600}};

        String[][] records = {
            {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}};

        for (int i = 0; i < fees.length; i++) {
            System.out.println(Arrays.toString(solution(fees[i], records[i])));
        }
    }

    static public int[] solution(int[] fees, String[] records) {
        Map<String, String> recordMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();

        for (String r : records) {
            feeMap.put(r.split(" ")[1], 0);
        }

        for (String r : records) {
            String carNum = r.split(" ")[1];
            String time = r.split(" ")[0];

            if (!recordMap.containsKey(carNum)) {
                recordMap.put(carNum, time);
            } else {
                String[] in = recordMap.remove(carNum).split(":");
                String[] out = time.split(":");

                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int minute = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);

                feeMap.put(carNum, feeMap.get(carNum) + 60 * hour + minute);
            }
        }

        for (Entry<String, String> entry : recordMap.entrySet()) {
            String[] in = entry.getValue().split(":");

            int hour = 23 - Integer.parseInt(in[0]);
            int minute = 59 - Integer.parseInt(in[1]);

            feeMap.put(entry.getKey(), feeMap.get(entry.getKey()) + 60 * hour + minute);
        }

        List<String> cars = new ArrayList<>(feeMap.keySet());
        cars.sort(Comparator.comparingInt(Integer::parseInt));
        int[] answer = new int[cars.size()];

        for (int i = 0; i < answer.length; i++) {
            int time = feeMap.get(cars.get(i));
            answer[i] = fees[1];

            if (time > fees[0]) {
                answer[i] += Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            }
        }

        return answer;
    }
}
