import java.io.*;
import java.util.*;
public class BOJ_2110_공유기설치 {
	static List<Integer> houses;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		 houses = new ArrayList<>();
		for (int i=0; i<n; i++) houses.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(houses);
		
		int lC=0, rC=(houses.get(houses.size()-1)-houses.get(0))/(C-1), mC=0;
		int lh;
		while (lC<rC) {
			mC = (lC + rC+1)/2;
			lh=0;
			for (int i=0; i<C-2; i++) {
				if (lh ==n) {lh = n-1; break;}
				lh = bs(lh, n-1, houses.get(lh)+mC);
			}
			if (houses.get(n-1)-houses.get(lh)<mC) rC = mC-1;
			else lC = mC;
		}
		System.out.println(lC);
	}
	
	static int bs(int l, int r, int x) {
		int m=l;
		while (l<r) {
			m = (l+r)/2;
			if (houses.get(m)<x) l = m+1;
			else r=m;
		}
		return l;
	}

}
