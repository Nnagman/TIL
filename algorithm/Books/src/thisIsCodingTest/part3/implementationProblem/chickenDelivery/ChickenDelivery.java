package thisIsCodingTest.part3.implementationProblem.chickenDelivery;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private final int n;
    private final int r;
    private final int[] now; // 현재 조합
    private final ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i : now) {
                temp.add(arr.get(i));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class ChickenDelivery {
    public static int n, m;
    public static int[][] map = new int[50][50];
    public static ArrayList<Position> chicken = new ArrayList<>();
    public static ArrayList<Position> house = new ArrayList<>();

    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
        // 모든 집에 대하여
        for (Position position : house) {
            int hx = position.getX();
            int hy = position.getY();
            // 가장 가까운 치킨 집을 찾기
            int temp = (int) 1e9;
            for (Position candidate : candidates) {
                int cx = candidate.getX();
                int cy = candidate.getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp;
        }
        // 치킨 거리의 합 반환
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] == 1) house.add(new Position(r, c)); // 일반 집
                else if (map[r][c] == 2) chicken.add(new Position(r, c)); // 치킨집
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);
        ArrayList<ArrayList<Position>> chickenList = comb.getResult();

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (ArrayList<Position> positions : chickenList) {
            result = Math.min(result, getSum(positions));
        }
        System.out.println(result);
    }
}
