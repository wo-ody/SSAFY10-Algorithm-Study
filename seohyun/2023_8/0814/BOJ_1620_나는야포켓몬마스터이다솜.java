import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1620_나는야포케몬마스터이다솜 {
	static int N,M;
	static Map<String,Integer> return_digit = new HashMap<>();
	static Map<Integer,String> return_name = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String p = br.readLine();
			return_digit.put(p, i+1);
			return_name.put(i+1, p);
		}
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			try {
				int num = Integer.parseInt(input);
				sb.append(return_name.get(num)).append("\n");
			}catch(Exception e) {
				sb.append(return_digit.get(input)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
