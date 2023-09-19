package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.PriorityQueue;

public class BOJ_1715_카드_정렬하기 {
	static int[] lst;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int s = 0; s < size; s++) {
			int elem = Integer.parseInt(br.readLine());
			pq.add(elem);
		}
		int sum = 0;
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum += a + b;
			pq.add(a + b);
		}
		System.out.println(sum);
	}

}
