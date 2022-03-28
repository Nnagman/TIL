package thisIsCodingTest.part2.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class UpDownLeftRight2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] movesTypes = {"L", "R", "U", "D"};

        int x = 1;
        int y = 1;

        sc.nextLine();
        String[] moves = sc.nextLine().split(" ");

        int ny = 0;
        int nx = 0;

        for (String move : moves) {
            for (int i = 0; i < 4; i++) {
                if (movesTypes[i].equals(move)) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
            if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
