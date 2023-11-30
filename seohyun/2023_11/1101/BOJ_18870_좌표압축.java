package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_18870_좌표압축 {
	static int N;
	static int[] num;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		simulation();
	}
	
	static int lower_bound(int key , int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			if(arr[mid] < key) low = mid + 1;
			else high = mid;
		}
		return high;
	}
	
	static void simulation() {
		
		Set<Integer> set = new TreeSet<>();
		for(int su : num) set.add(su);
		
		int[] arr = new int[set.size()];
		
		int idx = 0;
		for(Integer su : set) arr[idx++] = su;
		
		
		for(int su : num) sb.append(lower_bound(su , arr)).append(' ');
		System.out.println(sb);
	}

}
