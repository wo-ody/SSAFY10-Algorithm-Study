import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int tc;
	static int n, m;

	public static void main(String[] args) throws IOException {
		tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			String bin_m = Integer.toBinaryString((1 << 30) | m);  // 이진수변환
			String sub = bin_m.substring(bin_m.length()-n);
			String all_bit = Integer.toBinaryString((1 << n)-1);  // 뒤에서 켜진 모든 비트
			sb.append("#").append(t).append(" ").append(sub.equals(all_bit) ? "ON" : "OFF").append("\n");
		}
		System.out.println(sb);
	}
}
