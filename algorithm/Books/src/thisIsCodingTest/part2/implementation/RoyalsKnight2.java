package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class RoyalsKnight2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.next();

        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        int count = 0;

        for (int[] move : moves) {
            int x = now.charAt(0) - 97 + move[0];
            int y = now.charAt(1) - 48 + move[1];
            if (x < 1 || x > 8 || y < 1 || y > 8) continue;
            count++;
        }

        System.out.println(count);
    }
}
