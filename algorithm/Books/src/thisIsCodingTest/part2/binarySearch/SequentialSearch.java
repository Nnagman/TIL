package thisIsCodingTest.part2.binarySearch;

import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        int n = sc.nextInt();
        String findStr = sc.next();
        sc.nextLine();
        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        sc.nextLine();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(findStr)) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
