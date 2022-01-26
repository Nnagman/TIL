package practice.greedy.lifeboat;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50, 50, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
