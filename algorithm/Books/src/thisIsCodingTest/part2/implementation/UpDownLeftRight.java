package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class UpDownLeftRight {
    public static void main(String[] args) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int x = 1;
        int y = 1;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] moves = sc.nextLine().split(" ");
        char[] moveTypes = {'U', 'D', 'L', 'R'};

        int nx = 0, ny = 0;

        for (String move : moves) {
            for (int i = 0; i < 4; i++) {
                if (move.charAt(0) == moveTypes[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
            if (nx < n && 0 < nx && ny < n && 0 < ny) {
                x = nx;
                y = ny;
            }
        }
    }
}
