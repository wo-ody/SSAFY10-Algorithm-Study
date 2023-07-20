class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if (ineq.equals(">") && eq.equals("="))  // 문자열(String) 비교는 equals를 사용해야 함 
            return n >= m ? 1 : 0;
        else if (ineq.equals("<") && eq.equals("="))
            return n <= m ? 1 : 0;
        else if (ineq.equals(">") && eq.equals("!"))
            return n > m ? 1 : 0;
        else if (ineq.equals("<") && eq.equals("!"))
            return n < m ? 1 : 0;
        return answer;
    }
}
