package studyAuthenticating;

import java.io.*;
import java.util.*;

public class BOJ_2164_카드2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		int result = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= T; i++) queue.offer(i);
		
		while(queue.size() != 1){	
			queue.poll();
			queue.offer(queue.poll());
		}
    
		System.out.println(queue.poll());
	}
}
