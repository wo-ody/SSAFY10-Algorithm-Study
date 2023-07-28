import java.util.Scanner;

public class BOJ_10986_나머지합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수열의 개수
		int M = sc.nextInt();	// 나누는 수
		long[] S = new long[N];	// 합배열
		long[] C = new long[M]; // 나머지가 같은 값들을 인덱스로 받아 카운트
		long answer = 0;
		
		S[0] = sc.nextInt();	// 첫번째 인덱스 값 넣기
		for (int i = 1; i < N; i++) {	// 두번째 인덱스부터 채우기
			S[i] = S[i-1] + sc.nextInt();	// 합배열 만들기
		}
		
		for (int i = 0; i < N; i++) {	
			int remainder = (int) (S[i] % M);
			if (remainder == 0) answer++; // 나누기가 떨어지는 합의 개수세기
			C[remainder]++;				  // 같은 나머지 값 카운트 
		}
		
		// 조합 구현
		for (int i = 0; i < M; i++) {	//C의 인덱스는 나머지값, M은 나누는 값이라서 C[i]<M이다.
			if (C[i] > 1) {
				answer = answer + (C[i] * (C[i] - 1) / 2);	// 인접한 인덱스 중 2개를 뽑는 경우의 수를 더하기
				
			}
		}
		System.out.println(answer);
	}

}
