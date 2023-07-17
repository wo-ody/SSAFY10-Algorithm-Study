import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		List<Long> arr = new ArrayList<>();
		for (int i=0; i<n; i++) arr.add(sc.nextLong());
		Collections.sort(arr);

		int ans = 0;
		for (int i=0; i<n; i++) {
			Long K = arr.get(i); // K를 나타낼 수 있는지 검사
			int s = 0;
			int e = n-1;
			while (s < e) { // 투 포인터 s, e로 탐색
				Long t = arr.get(s) + arr.get(e);
				if (t < K) s++;
				else if (t > K) e--;
				else {
					if (s!=i && e!=i) {
						ans++;
						break;
					} 
					else if (s==i) s++; // 자신을 포함하면 x
					else e--;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	} // main
}