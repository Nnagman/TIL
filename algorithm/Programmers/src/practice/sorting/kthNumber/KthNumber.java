package practice.sorting.kthNumber;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution2(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] targetArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(targetArr);
            answer[i] = targetArr[commands[i][2] - 1];
        }

        return answer;
    }

    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] targetArr = getSlice(array, commands[i][0], commands[i][1]);
            targetArr = getSort(targetArr, 0, 1);
            answer[i] = targetArr[commands[i][2] - 1];
        }

        return answer;
    }

    public static int[] getSlice(int[] array, int start, int end) {
        int[] slicedArr = new int[end - start + 1];

        for (int i = 0; i < slicedArr.length; i++) {
            slicedArr[i] = array[i + start - 1];
        }

        return slicedArr;
    }

    public static int[] getSort(int[] array, int n, int m) {
        if (n + 1 == array.length) return array;

        if (array[n] > array[m]) {
            int tmp = array[n];
            array[n] = array[m];
            array[m] = tmp;
        }

        if (m + 1 == array.length) return getSort(array, n + 1, n + 2);
        else return getSort(array, n, m + 1);
    }
}
