import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BOJ_1213_팰린드롬만들기 {
    static int[] alphbet = new int[26];
    static final String IMPOSSIBLE = "I'm Sorry Hansoo";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            alphbet[ (c - 'A') ]++;
        }

        int cnt = 0; // 홀수의 개수
        int idx = 0; //홀수개인 인덱스
        for (int i = 0; i < 26; i++) {
            if(alphbet[i] % 2 == 1) {
                cnt++;
                idx = i;
            }

        }

        if(cnt > 1 || (str.length()%2==0 && cnt==1) ||
                str.length()%2==1 && cnt==0) sb.append(IMPOSSIBLE);
        else {
            Deque<Character> stack = new ArrayDeque<>();
            Queue<Character> q = new ArrayDeque<>();

            for(int i=0; i<26; i++) {
                for (int j = 0; j < alphbet[i]/2; j++) {
                    stack.push((char) (i + 65));
                    q.add((char) (i+65));
                }
            }

            for (int i=0; i<str.length()/2; i++){
                sb.append(q.poll());
            }
            if(str.length()%2 == 1) sb.append((char) (idx+65));
            for(int i=0; i<str.length()/2; i++) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);
    }
}
