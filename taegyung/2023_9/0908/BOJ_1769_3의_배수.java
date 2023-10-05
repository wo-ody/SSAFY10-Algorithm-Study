package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_1769_3의_배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();

        Stack<Integer> numArr = new Stack<>();
        for(int i = 0 ; i < X.length(); i ++){
            numArr.push(Integer.parseInt(Character.toString(X.charAt(i))));
        }

        int cnt = 0;

        while (numArr.size() > 1){
            cnt ++;
            int sum = 0 ;
            while(!numArr.isEmpty())
                sum += numArr.pop();

            while(sum > 0){
                numArr.push(sum%10);
                sum /= 10;

            }
        }
        System.out.println(cnt);
        System.out.println(numArr.get(0) % 3 == 0?"YES":"NO");
    }
}
