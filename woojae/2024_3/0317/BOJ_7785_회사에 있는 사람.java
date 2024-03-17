import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static TreeSet<String> hash = new TreeSet<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String info = st.nextToken();
			if(info.equals("enter"))
				hash.add(name);
			else
				hash.remove(name);
		}

		for (String i : hash)
			sb.append(i).append("\n");
		
		System.out.println(sb);
	}

}
