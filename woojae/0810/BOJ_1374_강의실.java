import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {  // 한 강의실에서 진행되는 것이 아님
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int num, s_time, e_time; 
		int answer = 0;
		int[][] arr = new int[n][3];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			s_time = Integer.parseInt(st.nextToken());
			e_time = Integer.parseInt(st.nextToken());
			arr[i] = new int[] {num, s_time, e_time};
		}
		Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);
		for(int i = 0; i < n; i++) {
			while(!q.isEmpty() && q.peek() <= arr[i][1])
				q.poll();
			q.add(arr[i][2]);
			answer = answer < q.size() ? q.size() : answer;
		}
		System.out.println(answer);
	}
}
