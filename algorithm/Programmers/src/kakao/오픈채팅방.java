package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(record)));
    }

    static private String[] solution(String[] record) {
        int len = record.length;
        HashMap<String, String> nameMap = new HashMap<>();
        Stack<String[]> stack = new Stack<>();

        String[] arr;

        for (String s : record) {
            arr = s.split(" ");
            if (arr[0].equals("Enter") || arr[0].equals("Change")) {
                nameMap.put(arr[1], arr[2]);
            }
            if (arr[0].equals("Enter") || arr[0].equals("Leave")) {
                stack.add(new String[]{arr[0], arr[1]});
            }
        }

        int size = stack.size();
        String[] answer = new String[size];
        int cnt = size-1;

        while (!stack.isEmpty()) {
            arr = stack.pop();
            if (arr[0].equals("Enter")) {
                answer[cnt] = nameMap.get(arr[1]) + "님이 들어왔습니다.";
            } else if (arr[0].equals("Leave")) {
                answer[cnt] = nameMap.get(arr[1]) + "님이 나갔습니다.";
            }
            cnt -= 1;
        }

        return answer;
    }
}
