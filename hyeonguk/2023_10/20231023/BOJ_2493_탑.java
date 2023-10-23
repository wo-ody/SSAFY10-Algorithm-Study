import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		nums= new int[N];
		Deque<Top> stack = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.offer(new Top(i, height));
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.offer(new Top(i, height));
						break;
					}
					
					Top top = stack.peekLast();
					
					if(top.height > height) {
						sb.append(top.num+" ");
						stack.offer(new Top(i, height));
						break;
					}else {
						stack.pollLast();
					}
				}
			}
		}
		
		System.out.println(sb);

	}
	
	static class Top{
		int num, height;
		Top(int num, int height){
			this.num = num;
			this.height = height;
		}
	}
}
