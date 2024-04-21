package algorithm2024.mar.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17298_옼큰수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Num{
		int idx, n;

		public Num(int idx, int n) {
			this.idx = idx;
			this.n = n;
		}
	}

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] NGE = new int[N];
		st = new StringTokenizer(br.readLine());

		Deque<Num> stk = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()&&stk.peek().n<n){
				Num num = stk.pop();
				NGE[num.idx] = n;
			}
			stk.push(new Num(i,n));
		}
		while (!stk.isEmpty()){
			Num num = stk.pop();
			NGE[num.idx] =-1;
		}
		for (int i : NGE) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
