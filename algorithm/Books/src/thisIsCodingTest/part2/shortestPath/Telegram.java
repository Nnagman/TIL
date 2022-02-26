package thisIsCodingTest.part2.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class City implements Comparable<City> {
    private final int index;
    private final int distance;

    public City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(City c) {
        if (this.distance < c.distance) {
            return -1;
        }
        return 1;
    }
}

public class Telegram {
    public static int INF = (int) 1e9;
    public static int n, m, c;
    public static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    public static int[] d = new int[30001];

    public static void dijkstra(int c) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(c, 0));
        d[c] = 0;

        while (!pq.isEmpty()) {
            City city = pq.poll();
            int dist = city.getDistance();
            int now = city.getIndex();

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new City(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new City(y, z));
        }

        Arrays.fill(d, INF);

        dijkstra(c);

        int count = 0;
        int time = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count += 1;
                time = Math.max(time, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println(count - 1 + " " + time);
    }
}
