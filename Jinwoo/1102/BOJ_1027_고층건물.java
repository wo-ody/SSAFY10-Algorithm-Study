import java.io.*;
import java.util.*;
public class BOJ_1027_고층건물 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] building = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) building[i]= Integer.parseInt(st.nextToken());
		//입력받기
		
		int[] cansee = new int[n]; //보이는 건물 수 더하겠습니다.
		double a, b; boolean flag;
		for (int i=0; i<n; i++) {
			cansee[i]+= (i==0||i==n-1)? 1:2; // 양옆건물은 무조건 보임
			for (int j=i+2; j<n; j++) {
				a = (double)(building[j]-building[i]) / (j-i);
				b = (double)building[i]-a*i; // y = ax + b
				flag = true;
				for (int k = i+1; k<j; k++) {
					if (building[k]>= a*k+b) {
						flag=false; // 직선보다 점이 위에있네요
						break;
					}
				}
				if (flag) {cansee[i]++; cansee[j]++;} // 보이면 ++
			}
		}
		int ans=0;
		for (int i=0; i<n; i++) ans = Math.max(ans, cansee[i]);
		if (n==1) ans=0;
		System.out.println(ans);
	}
	
}
