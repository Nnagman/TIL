package thisIsCodingTest.part3.dfsAndBfs.movingBlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    private final int pos1X;
    private final int pos1Y;
    private final int pos2X;
    private final int pos2Y;
    private final int distance;

    public Node(int pos1X, int pos1Y, int pos2X, int pos2Y, int distance) {
        this.pos1X = pos1X;
        this.pos1Y = pos1Y;
        this.pos2X = pos2X;
        this.pos2Y = pos2Y;
        this.distance = distance;
    }

    public int getPos1X() {
        return pos1X;
    }

    public int getPos1Y() {
        return pos1Y;
    }

    public int getPos2X() {
        return pos2X;
    }

    public int getPos2Y() {
        return pos2Y;
    }

    public int getDistance() {
        return distance;
    }
}

public class MovingBlock {
    private static ArrayList<Node> getNextPos(Node pos, int[][] board) {
        ArrayList<Node> nextPos = new ArrayList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int pos1NextX = pos.getPos1X() + dx[i];
            int pos1NextY = pos.getPos1Y() + dy[i];
            int pos2NextX = pos.getPos2X() + dx[i];
            int pos2NextY = pos.getPos2Y() + dy[i];
            int distanceNext = pos.getDistance() + 1;
            if (board[pos1NextX][pos1NextY] == 0 && board[pos2NextX][pos2NextY] == 0) {
                nextPos.add(new Node(pos1NextX, pos1NextY, pos2NextX, pos2NextY, distanceNext));
            }
        }

        int[] hor = {-1, 1};
        if (pos.getPos1X() == pos.getPos2X()) {
            for (int i = 0; i < 2; i++) {
                if (board[pos.getPos1X() + hor[i]][pos.getPos1Y()] == 0 && board[pos.getPos2X() + hor[i]][pos.getPos2Y()] == 0) {
                    nextPos.add(new Node(pos.getPos1X(), pos.getPos1Y(), pos.getPos1X() + hor[i], pos.getPos1Y(), pos.getDistance() + 1));
                    nextPos.add(new Node(pos.getPos2X(), pos.getPos2Y(), pos.getPos2X() + hor[i], pos.getPos2Y(), pos.getDistance() + 1));
                }
            }
        }

        int[] ver = {-1, 1};
        if (pos.getPos1Y() == pos.getPos2Y()) {
            for (int i = 0; i < 2; i++) {
                if (board[pos.getPos1X()][pos.getPos1Y() + ver[i]] == 0 && board[pos.getPos2X()][pos.getPos2Y() + ver[i]] == 0) {
                    nextPos.add(new Node(pos.getPos1X(), pos.getPos1Y(), pos.getPos1X(), pos.getPos1Y() + ver[i], pos.getDistance() + 1));
                    nextPos.add(new Node(pos.getPos2X(), pos.getPos2Y(), pos.getPos2X(), pos.getPos2Y() + ver[i], pos.getDistance() + 1));
                }
            }
        }

        return nextPos;
    }

    private static int solution(int[][] board) {
        int n = board.length;
        int[][] newBoard = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, n);
        }

        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node pos = new Node(1, 1, 1, 2, 0);
        q.offer(pos);
        visited.add(pos);

        while (!q.isEmpty()) {
            pos = q.poll();
            if ((pos.getPos1X() == n && pos.getPos1Y() == n) || (pos.getPos2X() == n && pos.getPos2Y() == n)) {
                return pos.getDistance();
            }
            ArrayList<Node> nextPos = getNextPos(pos, newBoard);
            for (Node next : nextPos) {
                boolean check = true;
                for (Node visit : visited) {
                    if (next.getPos1X() == visit.getPos1X() && next.getPos1Y() == visit.getPos1Y() && next.getPos2X() == visit.getPos2X() && next.getPos2Y() == visit.getPos2Y()) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    q.offer(pos);
                    visited.add(pos);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }
}
