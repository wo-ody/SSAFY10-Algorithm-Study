import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if (str.equals("ENTER")) {
				set = new HashSet<>();
				continue;
			}
			if(!(set.contains(str))) {
				set.add(str);
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
