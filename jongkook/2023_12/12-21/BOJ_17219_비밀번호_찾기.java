import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호_찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String ID = st.nextToken();
			String password = st.nextToken();
			map.put(ID, password);
		}
		while(m-- > 0) {
			System.out.println(map.get(br.readLine()));
		}
	}

}
