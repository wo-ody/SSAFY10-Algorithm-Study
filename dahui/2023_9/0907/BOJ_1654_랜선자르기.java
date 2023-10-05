import java.io.*;
import java.util.*;

public class Main {
    static int K,N;
    static long ans,max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		long [] arr= new long[K];
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		ans = binarySearch(arr, N, max);

		System.out.println(ans);
	}
    
	private static long binarySearch(long arr[], int N, long max) {
		long half = 0;
		long min = 1;

		while(min <= max) {
			half = (min + max)/2;
			long count = 0;

			for(long num : arr) {
				count += num / half;
			}

			if(count < N) {
				max = half-1;
			}
			else {
				min = half+1;
			}
		}
		return (max+min)/2;
	}
}
