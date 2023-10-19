package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12015_가장긴증가하는부분수열2 {
	static int N;
	static int[] input;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		LIS = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = input[0];
		int idx = 1;
		
		for(int i=1; i<N; i++) {
			int key = input[i];
			if(LIS[idx-1] < key) { 
				LIS[idx++] = key; 
			}else if(LIS[0] > key){
				LIS[0] = key;
			}else {
				int keyIdx = Arrays.binarySearch(LIS,0,idx,key);
				LIS[keyIdx<0? -(keyIdx+1) :keyIdx] = key;
			}
		}
		
		System.out.println(idx);
		
 
	}

}
