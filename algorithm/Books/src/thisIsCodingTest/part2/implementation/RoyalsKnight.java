package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class RoyalsKnight {
    public static void main(String[] args) {
        int n = 8;
        char[] dy = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        Scanner sc = new Scanner(System.in);
        String target = sc.next();

        int x = target.charAt(1) - '0';
        int y = 0;

        for (int i = 0; i < 8; i++) {
            if (dy[i] == target.charAt(0)) {
                y = i + 1;
            }
        }

        int ans = 0;
        int nx, ny;

        for (int[] move : moves) {
            nx = x + move[0];
            ny = y + move[1];
            if (nx < 1 || n < nx || ny < 1 || n < ny) continue;
            ans += 1;
        }

        System.out.println(ans);
    }
}
