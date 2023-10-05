import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {

	static BufferedWriter bw;
	static int N, M, answer;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);	// 배열
		
		M = Integer.parseInt(br.readLine());	// 찾을 수의 개수

		st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			answer = upperBound(A,target,0,N)-lowerBound(A,target,0,N);
			bw.write(answer+" ");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
	static int lowerBound(int[] array, int target, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if(array[mid] >= target) end = mid;
			else start = mid+1;
		}
		return start;
	}
	static int upperBound(int[] array, int target, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if(array[mid] > target) end = mid;
			else start = mid+1;
		}
		return start;
	}

}
