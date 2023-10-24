package algorithm2022.oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack();
		for(int i = 0; i<k;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num>0) {
				stk.push(num);
			}else if(num==0) {
				stk.pop();
			}
		}
		int sum = 0;
		for(int i : stk) {
			sum+=i;
		}
		System.out.print(sum);
	}
}
