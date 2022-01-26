package thisIsCodingTest.part3.implementationProblem.lockAndKey;

public class LockAndKey {
    private static int[][] rotateMatrixBy90Degree(int[][] key) {
        int n = key.length;
        int m = key[0].length;
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n - i - 1] = key[i][j];
            }
        }

        return temp;
    }

    private static boolean check(int[][] new_lock) {
        int len = new_lock.length / 3;
        for (int i = len; i < len * 2; i++) {
            for (int j = len; j < len * 2; j++) {
                if (new_lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        int[][] new_lock = new int[n * 3][n * 3];

        for (int i = 0; i < n; i++) {
            System.arraycopy(lock[i], 0, new_lock[i + n], n, n);
        }

        for (int r = 0; r < 4; r++) {
            key = rotateMatrixBy90Degree(key);
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            new_lock[x + i][y + j] += key[i][j];
                        }
                    }
                    if (check(new_lock)) return true;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            new_lock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }
}
