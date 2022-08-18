package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기 {

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, x, y, cnt = 0;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> list = new ArrayList<>();
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));
                    arr[i][j] = 0;
                    list.add(1);
                    cnt += 1;

                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        for (int k = 0; k < 4; k++) {
                            x = node.x + dx[k];
                            y = node.y + dy[k];
                            if (x > -1 && y > -1 && x < N && y < N && arr[x][y] == 1) {
                                arr[x][y] = 0;
                                q.add(new Node(x, y));
                                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
