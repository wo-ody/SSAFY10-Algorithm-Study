package studyAuthenticating;

import java.util.Collections;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

//우선순위 큐
public class BOJ_1655_가운데를_말해요 {

//	static PriorityQueue<Integer> first;
//	static PriorityQueue<Integer> second;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
						
		for(int tc = 0; tc < T; tc++){
			int value = Integer.parseInt(br.readLine());
			if(maxHeap.size() == minHeap.size()) maxHeap.offer(value);			
			else minHeap.offer(value);
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
				if(maxHeap.peek() > minHeap.peek()){
					int myPoll = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(myPoll);					
				}
			}
			bw.write(String.valueOf(maxHeap.peek())+ "\n");			
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
