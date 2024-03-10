package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BOJ_6198_옥상_꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int t = 0; t < T; t++){
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= height) stack.pop();

            result += stack.size();

            stack.add(height);
        }
        System.out.println(result);
    }
}

