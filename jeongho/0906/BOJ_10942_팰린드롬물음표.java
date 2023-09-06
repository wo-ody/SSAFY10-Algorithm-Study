package algorithm2023.sep.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 자연수 N개를 입력받고
 * M개의 질문을 입력받음, 질문의 형식은 s부터 e까지가 팰린드롬인가?
 * 인덱스가 1부터 주어지므로 s와 e에 -1한 값을 사용
 * 탑 다운 방식으로 dp를 구현
 * 점화식: arr[s]==arr[e] && dp[s+1][e-1]
 * 양 끝의 수가 같고 한칸씩 줄인 경우가 팰린드롬인 경우
 * 
 */



public class BOJ_10942_팰린드롬물음표 {
	static int N, M, arr[];
	static boolean palin[][];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N개의 수 입력받음.
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		palin = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//M개의 질문 입력
		M = Integer.parseInt(br.readLine());
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			//s와 e가 1부터 N까지이므로 인덱스로 쓰기 위해 1씩 빼줌.
			int s = Integer.parseInt(st.nextToken())-1;
			int e =Integer.parseInt(st.nextToken())-1;
			//isPalin함수가 true이면 1, 아니면 0 출력
			sb.append(isPalin(s,e)?1:0).append("\n");
		}
		System.out.println(sb);
	}
	
	//팰린드롬 여부를 판단하는 재귀함수. 시작점과 끝점을 전달
	static boolean isPalin(int s, int e) {
		//시작점이 끝점과 같거나 크다면 팰린드롬
		if(s>=e) {
			palin[s][e] = true;
			return true;
		}
		//양 끝의 수가 다르다면 팰린드롬 아님.
		if(arr[s]!=arr[e])return false;
		//s에서 e까지가 이미 팰린드롬으로 기록되었으면 true
		if(palin[s][e])return true;
		
		//양끝을 한 칸씩 줄여서 해당 칸에 기록
		return palin[s][e] = isPalin(s+1,e-1);
	}
}
