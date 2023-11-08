import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001]; int ans= n; // 학생수, 최대키, 최대키인원
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t;
		for (int i=0; i<n; i++) {
			t = Integer.parseInt(st.nextToken());
			arr[t]++;
			if (arr[t]>2) ans--;
		}
		System.out.println(ans);
	}

}
