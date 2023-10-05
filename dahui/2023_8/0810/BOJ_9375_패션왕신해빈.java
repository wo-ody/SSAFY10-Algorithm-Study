import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String name = st.nextToken();
				String kind = st.nextToken();
				if(!map.containsKey(kind)) {
					map.put(kind, 1);
				}else {
					map.put(kind, map.get(kind)+1);
				}
			}
			int ans = 1;
			for (int val : map.values()) {
				ans *= val + 1;
			}
			System.out.println(ans-1);
		}
		
	}

}
