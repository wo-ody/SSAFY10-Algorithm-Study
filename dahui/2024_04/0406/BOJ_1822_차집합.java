import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1822_차집합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());

		int ans = 0;
		ArrayList<Integer> A = new ArrayList<>();
		HashSet<Integer> B = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nB; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < nA; i++) {
			int num = A.get(i);
			if (!B.contains(num)){
				ans++;
				list.add(num);
			}
		}
		Collections.sort(list);
		for(int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(ans);
		System.out.println(sb);
	}
}
