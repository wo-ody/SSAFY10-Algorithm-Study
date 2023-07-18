class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String x = a + "";
        String y = b + "";
        String a_b = x + y;
        int temp = Integer.parseInt(a_b);
        answer = (temp > 2 * a * b) ? (temp) : (2 * a * b);
        return answer;
    }
}
