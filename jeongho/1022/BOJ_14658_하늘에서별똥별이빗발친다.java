package algorithm2023.oct.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14658_하늘에서별똥별이빗발친다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	
	static int N,M,L,K;
	static ArrayList<Star> stars = new ArrayList<>();
	
	static class Star{
		int x, y;

		public Star(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Star other = (Star) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Star [x=" + x + ", y=" + y + "]\n";
		}
		
		
		
		
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i =0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars.add(new Star(x,y));
		}
		
		System.out.println(K-getAns());
		
		
	}
	
	static int getAns() {
		int max = 0;
		for(Star s : stars) {
			for(Star s2 : stars) {
				int cnt1 = 0;
				int cnt2 = 0;
				int x = Math.min(s2.x, s.x);
				int y = Math.min(s2.y, s.y);
				for(Star s3 : stars) {
					
					if(s3.x>=x&&s3.x-x<=L) {
						if(s3.y>=y&&s3.y-y<=L) {
							cnt1++;
						}
						else if(y>s3.y&&y-s3.y<=L) {
							cnt2++;
						}
					}
				}
				max = Math.max(max, Math.max(cnt1, cnt2));
				
				
			}
				
			
		}
		return max;
	}
}
