package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10876_중복빼고정렬하기 {

	static int N;
	static HashSet<Integer> hSet = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			hSet.add( Integer.parseInt(st.nextToken()) );
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(hSet);
        Collections.sort(list);
		
//		PriorityQueue<Integer> pqueue = new PriorityQueue<>(hSet);
//		int size = pqueue.size();
//		for (int i = 0; i < size; i++) {
//			sb.append(pqueue.poll()).append(" ");
//		}
        
        for (int x : list){
            sb.append(x).append(" ");
        }
        
		// 정답출력
		System.out.println(sb);
	}

}
