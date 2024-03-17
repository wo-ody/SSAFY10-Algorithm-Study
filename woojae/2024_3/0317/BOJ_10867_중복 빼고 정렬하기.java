import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static TreeSet<Integer> answer = new TreeSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)
			answer.add(Integer.parseInt(st.nextToken()));
		
		for (int i : answer)
			sb.append(i).append(" ");
		
		System.out.println(sb);
	}
}
