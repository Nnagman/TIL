package thisIsCodingTest.part2.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
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

public class EscapeMaze {
    public static int n, m;
    public static final int[][] arr = new int[201][201];
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
                if (arr[nx][ny] == 0) continue;
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return arr[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
