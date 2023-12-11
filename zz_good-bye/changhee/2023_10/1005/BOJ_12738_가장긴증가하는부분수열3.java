import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		arr= new int[n];
		
		int len = 1;
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i =1; i<n; i++) {
			int key =Integer.parseInt(st.nextToken());
			if(arr[len-1] < key) arr[len++] = key;	
			if(arr[len-1]>key) upper(0,len,key);
		}
		System.out.println(len);
	}

	public static void upper(int start, int end, int key) {
		while(start<end) {
			int mid = (start+end)/2;
			if(arr[mid]<key) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		arr[end] = key;
	}
}
