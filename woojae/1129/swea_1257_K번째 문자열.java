import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int tc;
	static int k;
	static String str;
	static TreeSet<String> set;
	
	public static void main(String[] args) throws IOException {
		tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			k = Integer.parseInt(br.readLine());
			str = br.readLine();
			sb.append("#").append(t).append(" ");
			solve();
		}
		System.out.println(sb);
	}
	
	static void solve() {
		set = new TreeSet<>();
		int len = str.length();
		for(int i = 1; i <= len; i++)
			for(int j = 0; j < len - i + 1; j++)  // start index의 범위는 점점 감소해야 함 len-1 ~ 0 
				set.add(str.substring(j, j+i));
		
		try {
			sb.append(set.toArray()[k-1]).append("\n");
		} catch(Exception e) {
			sb.append("none").append("\n");
		}
	}
}
