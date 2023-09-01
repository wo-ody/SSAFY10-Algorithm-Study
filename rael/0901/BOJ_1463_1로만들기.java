package st0901;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int N;
	static int memoi[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		memoi = new int[N+1];
		
		//1은 이미 목적을 완료했으므로 0. 2부터 시작해서 구한다.
		for(int i=2; i<=N; i++) {
			memoi[i] = memoi[i-1]+1;
			
			//나누어 지는 경우 최솟값으로 대체
			if(i%3 == 0) 
				memoi[i] = Math.min(memoi[i], memoi[i/3]+1);
			if(i%2 == 0) 
				memoi[i] = Math.min(memoi[i], memoi[i/2]+1);
		}
		
		System.out.println(memoi[N]);
	}
}
