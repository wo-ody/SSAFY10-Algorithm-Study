public class 삼진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        String three = Integer.toString(n, 3);

        StringBuilder sb = new StringBuilder(three);
        String rev = sb.reverse().toString();

        answer = Integer.parseInt(rev, 3);

        return answer;
    }

}
