package thisIsCodingTest.part3.implementationProblem.checkTheExteriorWall;

import java.util.ArrayList;

class Permutation {
    private final int n;
    private final int r;
    private final int[] now;
    private final ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j : now) {
                temp.add(j);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

public class CheckTheExteriorWall {
    private static int solution(int n, int[] weak, int[] dist) {
        ArrayList<Integer> weakList = new ArrayList<>();
        for (int i : weak) weakList.add(i);
        for (int i : weak) weakList.add(i + n);

        int answer = dist.length + 1;

        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();

        for (int start = 0; start < distList.size(); start++) {
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1;
                int position = weakList.get(start) + distList.get(i).get(0);
                for (int index = start; index < start + weak.length; index++) {
                    if (position < weakList.get(index)) {
                        cnt += 1;
                        if (cnt > dist.length) break;
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt);
            }
        }
        if (answer > dist.length) return -1;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }
}
