public class PGS_공배수 {
    public static void main(String[] args) {
        int number = 60;
        int n = 2;
        int m = 3;
        PGS_공배수_Solution solution = new PGS_공배수_Solution();
        System.out.println(solution.solution(number, n, m));
    }
}

class PGS_공배수_Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        answer = (number % n == 0 && number % m == 0) ? 1 : 0;
        return answer;
    }
}
