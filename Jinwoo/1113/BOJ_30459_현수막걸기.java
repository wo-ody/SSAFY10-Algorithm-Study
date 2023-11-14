import java.io.*;
import java.util.*;
public class BOJ_30459_현수막걸기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Integer> brr = new ArrayList<>();
		for (int i=0; i<m; i++) brr.add(Integer.parseInt(st.nextToken()));
		
		
		boolean[] A = new boolean[40001];
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				A[Math.abs(arr[i]-arr[j])] = true;
			}
		}
		r*=2;
		Collections.sort(brr);
		int s, e, mid, t;
		List<Integer> B = new ArrayList<>();
		for (int i=1; i<40001; i++) {
			if (!A[i]) continue;
			s=0; e=m-1;
			while (s<e) {
				mid = (s+e+1)/2;
				if (i*brr.get(mid) > r) e = mid-1;
				else s = mid;
			}
			t = brr.get(s)*i;
			if (t >r) continue;
			B.add(t);
		}
		Collections.sort(B, Collections.reverseOrder());
		if (B.size()==0) System.out.println(-1);
		else {
			System.out.print(B.get(0)/2);
			System.out.println(B.get(0)%2==0? ".0":".5");
		}
	}

}
