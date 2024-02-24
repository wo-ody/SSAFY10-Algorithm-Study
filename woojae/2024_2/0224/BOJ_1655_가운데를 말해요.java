import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static int n;
	static int[] nums;
	static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);  // 최대힙 -> head의 값은 중간값의 역할
	static PriorityQueue<Integer> right = new PriorityQueue<>();  // 최소힙 -> 중간 값 이후의 값

	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(br.readLine());
		
		for (Integer num : nums) {
			if(left.size() == right.size())
				left.add(num);
			else
				right.add(num);
			
			if(!right.isEmpty())
				if(left.peek() > right.peek()) {
					int left_data = left.poll(), right_data = right.poll();
					left.add(right_data);
					right.add(left_data);
				}
			sb.append(left.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
