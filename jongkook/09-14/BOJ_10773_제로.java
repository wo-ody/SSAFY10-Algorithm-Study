import java.util.*;
import java.io.*;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i< T; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(temp == 0) stack.pollLast();
            else stack.offerLast(temp);
        }

        int sum = 0;
        for(int num : stack) sum += num;


        System.out.println(sum);

    }
}
