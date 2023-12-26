package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144_ListofUniqueNumbers {
	static int N;
	static long ans;
	static int[] input;
	static boolean[] num = new boolean[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<N+1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 1; //보고 있는 연속적인 배열의 시작 인덱스
		int r = 0; //보고 있는 연속적인 배열의 끝 인덱스
		
		while(l <= N) { 
			while(r+1 <=N && !num[input[r+1]]) { //배열을 넘지않고 사용하지 않은 숫자인지
				r++; //길이 늘려나가기
				num[input[r]] = true; //중복 체크 해주기
			}
			
			ans += r - l + 1; //해당 길이만큼이 가능한 개수
			
			num[input[l++]] = false; //다 보고 나면 이전 l 계산에서 제외 && l 늘리기
		}
		
		System.out.println(ans);
	}

}
