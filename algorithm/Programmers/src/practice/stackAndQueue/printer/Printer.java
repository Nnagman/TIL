package practice.stackAndQueue.printer;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> originQueue = new LinkedList<>();

        for (int i : priorities) {
            queue.offer(i);
        }
        for (int i = 0; i < priorities.length; i++) {
            originQueue.offer(i);
        }

        int result = 1;
        while (!originQueue.isEmpty()) {
            int originIndex = originQueue.poll();
            int originValue = priorities[originIndex];
            int maxValue = queue.peek();
            if (originValue < maxValue) {
                originQueue.offer(originIndex);
            } else if (originValue == maxValue) {
                if (originIndex == location) {
                    return result;
                } else {
                    queue.remove();
                    result++;
                }
            }
        }
        return result;
    }

    public static int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for (int i : priorities) {
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;


        while (!que.isEmpty()) {
            Integer i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0)
                    break;
            } else {
                que.add(i);
                l--;
                if (l < 0)
                    l = que.size() - 1;
            }
        }

        return answer;
    }
}
