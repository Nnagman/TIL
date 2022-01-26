package thisIsCodingTest.part3.dfsAndBfs.avoidSurveillance;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private final int n; // 빈 공간 갯수
    private final int r; // 채울 공간 갯수
    private final int[] now; // 현재 조합
    private final ArrayList<ArrayList<Position>> result; // 모든 조합

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth != r) {
            if (target == n) return;
            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        } else {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i : now) temp.add(arr.get(i));
            result.add(temp);
        }
    }

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
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
        return x;
    }

    public int getY() {
        return y;
    }
}

public class AvoidSurveillance {
    public static int n;
    public static char[][] board = new char[6][6];
    public static ArrayList<Position> teachers = new ArrayList<>();
    public static ArrayList<Position> spaces = new ArrayList<>();

    private static boolean watch(int x, int y, int direction) {
        if (direction == 0) {
            while (y >= 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;
                y -= 1;
            }
        }
        if (direction == 1) {
            while (y < n) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;
                y += 1;
            }
        }
        if (direction == 2) {
            while (x >= 0) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;
                x -= 1;
            }
        }
        if (direction == 3) {
            while (x < n) {
                if (board[x][y] == 'S') return true;
                if (board[x][y] == 'O') return false;
                x += 1;
            }
        }
        return false;
    }

    private static boolean process() {
        for (Position teacher : teachers) {
            int x = teacher.getX();
            int y = teacher.getY();
            for (int i = 0; i < 4; i++) {
                if (watch(x, y, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
                if (board[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
                if (board[i][j] == 'X') {
                    spaces.add(new Position(i, j));
                }
            }
        }

        Combination comb = new Combination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> obstacleList = comb.getResult();

        boolean found = false;
        for (ArrayList<Position> obstacles : obstacleList) {
            for (Position obstacle : obstacles) {
                int x = obstacle.getX();
                int y = obstacle.getY();
                board[x][y] = 'O';
            }

            if (!process()) {
                found = true;
                break;
            }

            for (Position obstacle : obstacles) {
                int x = obstacle.getX();
                int y = obstacle.getY();
                board[x][y] = 'X';
            }
        }

        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
