package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1138_한_줄로_서기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//  수가 작은데 할당받은 수도 작다 => 내 앞에 아무도 없다는 뜻
		// 수가 큰데 할당받은 수는 작다. => 얘는 사실 알 길이 없음
		
		// 수가 작은데 할당받은 수가 크다 => 얘는 정확히 어디 들어가야할 지 나옴
		// 작은 수부터 확인하면서 어디 할당됐는지를 확인하면 되려나ㅓ
		
		int [] arr = new int[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			

		}
		
		
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = N ; i >= 1;  i --) {
			answer.add(arr[i],i);
		}
		
//		System.out.println(answer.toString());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<N;i++) {
			sb.append(answer.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}
