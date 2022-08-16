package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DFS와BFS {

    static class Node implements Comparable<Node> {

        int now, to;

        public Node(int now, int to) {
            this.now = now;
            this.to = to;
        }


        @Override
        public int compareTo(Node o) {
            if (this.now > o.now) {
                return 1;
            } else if (this.now < o.now) {
                return -1;
            } else {
                if (this.to < o.to) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    static int N, M, V;
    // [n][0] -> DFS, n[1] -> BFS
    static boolean[][] arr;

    static int x, y;

    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점 개수
        N = Integer.parseInt(st.nextToken());
        // 간선 개수
        M = Integer.parseInt(st.nextToken());
        // 시작 정점
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[N][2];

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        Collections.sort(list);
    }

    static void bfs(int s) {
        StringBuilder sb = new StringBuilder();

        Queue<Node> q = new LinkedList<>(list.stream().filter(o -> o.now == V).toList());

        sb.append(V).append(" ");
        arr[V][1] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(!arr[node.to][1]) {
                q.add(list.stream().filter(o -> o.now == V).findFirst().get());
            }
        }
    }
}
