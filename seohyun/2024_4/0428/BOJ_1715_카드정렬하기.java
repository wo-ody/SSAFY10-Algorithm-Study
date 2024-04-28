import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for (int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		long num = 0;
    
		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			num += temp1 + temp2;
			pq.add(temp1 + temp2);
		}
		
		System.out.println(num);
		
	}
}
