import java.util.*;
// 코드참고해서 겨우 품..
class Solution {
    final int limit = 10_000_000;

    public Integer[] solution(long begin, long end) {
        List<Integer> answerList = new ArrayList<Integer>();
        int left = (int) begin;
        int right = (int) end;

        for (int value = left; value <= right; value++) {
            if (value == 1) {
                answerList.add(0);
            } else {
                int gcd = gcd(value);
                answerList.add(gcd);
            }
        }
        return answerList.toArray(new Integer[0]);
    }
    private int gcd(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                int divideValue = value / i;

                if (divideValue <= limit) {
                    return divideValue;
                }
            }
        }

        return 1;
    }
}
