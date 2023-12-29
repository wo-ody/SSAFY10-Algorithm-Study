import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,n_list[],m;
	static int start,end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		n_list = new int[n];
    
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			n_list[i]=Integer.parseInt(token.nextToken());
		}
    
		m = Integer.parseInt(br.readLine());
		Arrays.sort(n_list);
		end = n_list[n-1];
		
		while(start<=end) {
			int mid = (start+end)/2;
			long sum = 0;
      
			for (int i = 0; i < n; i++) {
				if(n_list[i]<=mid) {
					sum+=n_list[i];
				}
				else {
					sum+=mid*(n-i);
					break;
				}
			}
      
			if(sum<=m) { // 초과 하지 않은 경우
				start = mid+1;
			}
			else { // 초과 했을 경우
				end = mid-1;			
			}
		}
		System.out.println(end);
	}

}
