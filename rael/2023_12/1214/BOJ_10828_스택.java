import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
    public static int n;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();
 
        n = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                int n2 = Integer.parseInt(st.nextToken());
                stack.push(n2);
 
            } else if (s.equals("top")) {
                if (stack.size() < 1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
 
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                if (stack.size() < 1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (s.equals("pop")) {
                if (stack.size() < 1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
 
            }
 
        }
    }
 
}
