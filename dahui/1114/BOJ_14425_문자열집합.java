import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int j=0; j<M; j++) {
			int size = set.size();
			
			String str = br.readLine();
			set.add(str);
			
			if(size == set.size()) {
				ans++;
			}else {
				set.remove(str);
			}
			
		}
		
		System.out.println(ans);

	}

}
