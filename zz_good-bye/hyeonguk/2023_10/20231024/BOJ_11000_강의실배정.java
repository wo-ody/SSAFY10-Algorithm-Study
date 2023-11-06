import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] lecture;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		lecture = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[i][0] = Integer.parseInt(st.nextToken());
			lecture[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lecture, (int[] o1, int[] o2)->{
			return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lecture[0][1]);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= lecture[i][0]) pq.poll();
			pq.offer(lecture[i][1]);
		}
		
		System.out.println(pq.size());
	}
}
