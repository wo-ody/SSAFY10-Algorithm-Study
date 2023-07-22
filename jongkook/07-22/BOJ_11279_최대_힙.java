package studyAuthenticating;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.IOException;

public class BOJ_11279_최대_힙 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int line = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
		for(int tc = 0; tc <line; tc++){
			int value = Integer.parseInt(br.readLine());
			if (PQ.isEmpty()&& value == 0) System.out.println(0);
			else if(!PQ.isEmpty()){
				if(value == 0) System.out.println(PQ.poll());				
				else PQ.offer(value);
			}
		}
	}

}
