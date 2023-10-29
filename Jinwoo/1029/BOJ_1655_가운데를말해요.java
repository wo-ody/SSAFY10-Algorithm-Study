import java.util.*;
import java.io.*;
public class practice{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Midq midq = new Midq();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			midq.add(Integer.parseInt(br.readLine()));
			sb.append(midq.poll()).append("\n");
		}
		System.out.println(sb);
	}//main
	
	static class Midq{
		static PriorityQueue<Integer> lq;
		static PriorityQueue<Integer> rq;
		static int size;
		
		Midq(){
			lq = new PriorityQueue<>((o1,o2)->o2-o1);
			rq = new PriorityQueue<>();
			size = 0;
		}
		void add(int x) {
			if (rq.size()==0) rq.add(x);
			else if (rq.peek()>x) lq.add(x);
			else rq.add(x);
			
			if (rq.size()-lq.size()>1) {
				lq.add(rq.poll());
			}else if (lq.size()-rq.size()>0) {
				rq.add(lq.poll());
			}
		}
		
		int poll() {
			if (lq.size()!=rq.size()) return rq.peek();
			return Math.min(lq.peek(), rq.peek());
		}
	}
}
