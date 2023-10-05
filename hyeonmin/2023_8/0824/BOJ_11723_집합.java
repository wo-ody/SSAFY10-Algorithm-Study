import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[] x = new boolean[21];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int c = 0;
			if(!(command.equals("all") || command.equals("empty"))) {
				c = Integer.parseInt(st.nextToken());
			}
			
			switch (command) {
			case "add":
				x[c] = true;
				break;
				
			case "remove":
				x[c] = false;
				break;
				
			case "check":
				sb.append( x[c] ? 1 : 0 ).append("\n");
				break;
				
			case "toggle":
				x[c] = !x[c];
				break;
				
			case "all":
				Arrays.fill(x, true);
				break;
				
			case "empty":
				Arrays.fill(x, false);
				
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
		
	}

}
