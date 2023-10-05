package studyAuthenticating;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BOJ_2075_N번째_큰_수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < T; j++){
				PQ.add(Integer.parseInt(st.nextToken()));
			}			
		}
		int N = 0;
		
		for(int i = 0; i < T; i++){
			N = PQ.poll();
		}
		
		System.out.println(N);
		
//		for(int[] v : lst) System.out.println(Arrays.toString(v));
		
		
	}
}
