package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5635_생일 {
	static int n;
	static ArrayList<p> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list.add(new p(str,day,month,year));
		}
		
		list.sort((o1, o2) -> {
		    if(o1.y != o2.y) { 
		        return o1.y - o2.y;
		    } else if(o1.m != o2.m) { 
		        return o1.m - o2.m;
		    } else { 
		        return o1.d - o2.d;
		    }
		});
		
		System.out.println(list.get(list.size()-1).name);
		System.out.println(list.get(0).name);


	}
	
	public static class p {
		String name; 
		int d, m, y;
		public p (String name, int d, int m, int y) {
			this.name = name;
			this.d=d;
			this.m=m;
			this.y=y;
		}
	}
}
