class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int end = (a == b && b == c) ? 4 : (a != b && b != c && a != c) ? 2 : 3;
        for (int i = 1 ; i < end; i++)
                answer *= (Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i));
        return answer;
    }
}
