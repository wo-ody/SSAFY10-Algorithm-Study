package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] chr;
        for(int t = 0; t < T; t++){
            chr = br.readLine().toCharArray();
            Deque<Character> start = new ArrayDeque<>();
            Deque<Character> last = new ArrayDeque<>();

            int size = chr.length;

            for(int s = 0 ; s < size; s++){
                if(start.isEmpty()) start.addLast(chr[s]);
                else {
                    if(start.peekLast() == '(' && chr[s] == ')') start.pollLast();
                    else start.addLast(chr[s]);
                }
            }
            System.out.println(start.isEmpty() ? "YES" : "NO");
        }
    }
}
