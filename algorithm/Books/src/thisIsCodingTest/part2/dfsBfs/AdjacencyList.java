package thisIsCodingTest.part2.dfsBfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                if (temp.get(0) == i) continue;
                list.add(temp);
            }
            System.out.println(temp);
        }
    }
}
