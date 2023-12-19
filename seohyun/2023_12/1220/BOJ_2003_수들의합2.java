import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int s=0, e=0, sum=0, cnt=0;
		while(true) {
			if(sum>=m) {
				sum -= arr[s++];
			}else if(e==n) break;
			else {
				sum += arr[e++];
			}
			if(sum==m) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}
