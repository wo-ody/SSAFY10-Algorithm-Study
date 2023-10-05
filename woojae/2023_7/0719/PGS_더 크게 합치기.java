class Solution {
    public int solution(int a, int b) {
        String str_a = "" + a;
        String str_b = "" + b;
        int a_b = Integer.parseInt(str_a+str_b);
        int b_a = Integer.parseInt(str_b+str_a);
        int answer = a_b > b_a ? a_b : b_a;
        return answer;
    }
}
