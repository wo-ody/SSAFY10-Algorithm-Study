package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_17609_회문 {
    static int N;
    static char[] chr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++){
            chr = br.readLine().toCharArray();
            int start = 0;
            int end = chr.length - 1;
            System.out.println(isPalindrome(start, end, 0));
        }
    }
    static int isPalindrome(int start, int end, int depth){
            if(depth >= 2) return 2;
            while(start < end) {
                if (chr[start] == chr[end]) {
                    start++;
                    end--;
                }
                else return Math.min(isPalindrome(start + 1, end, depth+1), isPalindrome(start, end - 1, depth+1));
            }
            return depth;
    }
}
