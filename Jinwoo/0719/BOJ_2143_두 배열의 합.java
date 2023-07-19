import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Integer> Amap = new HashMap<>();
	static HashMap<Integer, Integer> Bmap = new HashMap<>();
	public static void main(String[] args) {
		int T = sc.nextInt();
		int n = sc.nextInt();
		int[] A = new int[n+1];
		for (int i=0; i<n; i++) A[i+1] = sc.nextInt();
		int m = sc.nextInt();
		int[] B = new int[m+1];
		for (int i=0; i<m; i++) B[i+1] = sc.nextInt();
		
		for (int i =0; i<n; i++) A[i+1] += A[i];
		for (int i =0; i<m; i++) B[i+1] += B[i];
		
		for (int i=1; i<n+1; i++) {
			for (int j=i; j<n+1; j++) {
				int t = A[j]-A[i-1];
				if (Amap.containsKey(t)) Amap.put(t, Amap.get(t)+1);
				else Amap.put(t, 1);
			}
		}
		for (int i=1; i<m+1; i++) {
			for (int j=i; j<m+1; j++) {
				int t = B[j]-B[i-1];
				if (Bmap.containsKey(t)) Bmap.put(t, Bmap.get(t)+1);
				else Bmap.put(t, 1);
			}
		}
		Iterator<Integer> Aiter = Amap.keySet().iterator();
		long ans = 0;
		while (Aiter.hasNext()) {
			int key = Aiter.next();
			if (!Bmap.containsKey(T-key)) continue;
			ans += (long)Amap.get(key) * (long)Bmap.get(T-key);
		}
		System.out.println(ans);
	}//main
	
}