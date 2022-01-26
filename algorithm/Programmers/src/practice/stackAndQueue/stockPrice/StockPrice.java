package practice.stackAndQueue.stockPrice;

import java.util.Arrays;

import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        int min = 10000;

        for (int price : prices) {
            st.push(price);
            if (min > price) min = price;
        }

        while (!st.isEmpty()) {
            Integer n = st.pop();
            int t = 0;

            if (n == min) {
                t = prices.length - st.size() - 1;
            } else if (st.size() != prices.length - 1) {
                for (int i = st.size(); i < prices.length - 1; i++) {
                    if (n > prices[i]) break;
                    t++;
                    System.out.println(st.size() + " " + prices[i] + " " + n + " " + t);
                }
            }

            answer[st.size()] = t;
        }

        return answer;
    }
}
