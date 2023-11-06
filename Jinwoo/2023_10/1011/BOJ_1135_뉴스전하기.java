import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()),next, idx;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tree = new int[n];
		List<List<Integer>> dp = new ArrayList<>();
		for (int i=0; i<n; i++) {tree[i] = Integer.parseInt(st.nextToken()); dp.add(new ArrayList<>());}
		for (int i=n-1; i>0; i--) {
			next = 0; idx=1;
			Collections.sort(dp.get(i), (o1, o2)->o2-o1);
			for (int a : dp.get(i)) next = Math.max(a + idx++, next);
			dp.get(tree[i]).add(next);
		}
		next = 0; idx=1;
		Collections.sort(dp.get(0), (o1, o2)->o2-o1);
		for (int a : dp.get(0)) next = Math.max(a + idx++, next);
		System.out.println(next);
	}

}
