package practice.heap.diskController;

import java.util.*;

/**
 * [5,3] [2,6] [1,9]
 * <p>
 * 1. 3ms + 12ms + 22ms = 37ms
 * <p>
 * 2. 6ms + 6ms + 19ms = 31ms
 * <p>
 * If summary of wait time and job time is same.
 * The Priority Job is that which has short wait time.
 * <p>
 * [5,3] [6,6] [1,9]
 * <p>
 * 1. 8ms +16ms + 16ms = 40ms
 * <p>
 * 2. 8ms + 14ms + 22ms = 42ms
 * <p>
 * Also It dosent matter job time is lowest.
 * The matter is lowerst summary of wait time and job time.
 */
public class DiskController {
    public static void main(String[] args) {
        //int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
        //int[][] jobs = {{0, 10}, {2, 10}, {25, 10}, {25, 2}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] <= o2[0]) {
                return -1;
            }
            return 1;
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            }
            return 1;
        });

        int time = 0;
        int index = 0;
        int answer = 0;

        while (true) {
            System.out.println("====================================================================");
            System.out.println("Get Queue");
            while (index < jobs.length && jobs[index][0] <= time) {
                System.out.println("index: " + index + " jobs[index]: " + Arrays.toString(jobs[index]) + " time: " + time);
                queue.offer(jobs[index]);
                index++;
            }
            if (queue.size() == 0) {
                System.out.println("Start Time is : " + Arrays.toString(jobs[index]));
                time = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];
            System.out.println("index: " + index + " job: " + Arrays.toString(job) +
                    " Queue Size: " + queue.size() + " time: " + time + " Answer: " + answer);
            if (index == jobs.length && queue.size() == 0) {
                break;
            }
        }

        return answer / jobs.length;
    }
}