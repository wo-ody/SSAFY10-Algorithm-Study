import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static Node[] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
//		n = Integer.parseInt(br.readLine());
		arr = new Node[3];
		answer = 0;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Node(x, y);
		}
		solve();
	}
	
	static void solve() {
		long result = ccw(arr[0], arr[1], arr[2]);
		if(result > 0)
			System.out.println(1);
		else if(result < 0)
			System.out.println(-1);
		else
			System.out.println(0);
	}
	
	static long ccw(Node a, Node b, Node c) {
		return (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x);
	}
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}