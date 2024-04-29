import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2628_종이자르기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		ArrayList<Integer> listX = new ArrayList<>();
		ArrayList<Integer> listY = new ArrayList<>();
		listX.add(0);
		listY.add(0);
		listX.add(x);
		listY.add(y);

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				listY.add(Integer.parseInt(st.nextToken()));
			}else {
				listX.add(Integer.parseInt(st.nextToken()));
			}
		}

		int ans = 0;
		Collections.sort(listX);
		Collections.sort(listY);

		for (int i = 1; i < listX.size(); i++) {
			for (int j = 1; j<listY.size(); j++) {
				ans = Math.max(ans, (listY.get(j) - listY.get(j-1)) *  (listX.get(i) - listX.get(i-1)) );
			}
		}
		System.out.println(ans);
	}
}
