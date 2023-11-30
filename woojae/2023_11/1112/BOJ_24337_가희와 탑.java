package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_24337 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, a, b;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		solve();
		System.out.println(sb);
	}
	
	static void solve() {
		for(int i = 1; i < a; i++)  // 1부터 삽입 -> a-1까지
			arr.add(i);
		arr.add(Math.max(a, b));
		for(int i = b-1; i > 0; i--)  // b-1부터 1까지
			arr.add(i);
		
		if(arr.size() > n)
			System.out.println(-1);
		else {
			sb.append(arr.get(0)).append(" ");  
			// 두 가지 경우에 대해서 생각
			// a < b: b-1부터 세우며 highest ~ b-1 사이에 1을 배치하면 n을 만족함과 동시에 보이는 건물의 수를 만족시킴
			// a > b: 1부터 a-1까지 세우며 1 앞에 1의 건물이 얼마든지 있어도 상관없기에 0 ~ 1사이에 1을 배치하면 n을 만족함과 동시에 보이는 건물의 수를 만족시킴
			for(int i = 0; i < n - arr.size(); i++)  // n을 맞추기 위한 더미값 -> 사전순 배치를 위해 최소값인 1을 출력
				sb.append(1).append(" ");
			for(int i = 1; i < arr.size(); i++)  // 나머지 건물
				sb.append(arr.get(i)).append(" ");
		}		
	}
}
