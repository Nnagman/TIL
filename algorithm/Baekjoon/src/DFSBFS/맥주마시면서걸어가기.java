package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {

    static class Node {

        int x, y;
        boolean visited;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            visited = false;
        }
    }

    static int t, n, x, y, gap;
    static ArrayList<Node> list;
    static Queue<Node> q;
    static String[] ans;
    static String temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        ans = new String[t];

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            q = new LinkedList<>();

            for (int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                list.add(new Node(x, y));
            }

            q.add(list.get(0));
            temp = "sad";

            while (!q.isEmpty()) {
                Node node = q.poll();
                node.visited = true;

                x = list.get(list.size() - 1).x;
                y = list.get(list.size() - 1).y;
                gap = Math.abs(node.x - x) + Math.abs(node.y - y);
                if (gap < 1001) {
                    temp = "happy";
                    break;
                }

                for (int j = 1; j < n + 1; j++) {
                    x = list.get(j).x;
                    y = list.get(j).y;
                    gap = Math.abs(node.x - x) + Math.abs(node.y - y);
                    if (gap < 1001 && !list.get(j).visited) {
                        q.add(list.get(j));
                    }
                }
            }

            ans[i] = temp;
        }

        for (String s : ans) {
            System.out.println(s);
        }
    }
}
