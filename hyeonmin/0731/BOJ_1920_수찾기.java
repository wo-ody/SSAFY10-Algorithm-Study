import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	static boolean binarySearch(int[] arr, int n, int start, int end) {
		if(start > end) return false;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] < n) {
			return binarySearch(arr, n, mid+1, end);
		} else if (arr[mid] > n) {
			return binarySearch(arr, n, start, mid-1);
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			boolean answer = binarySearch(A, Integer.parseInt(st.nextToken()), 0, N-1);
			bw.write((answer ? 1 : 0) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}
