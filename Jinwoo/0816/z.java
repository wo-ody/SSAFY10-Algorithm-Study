import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		int r=Integer.parseInt(st[1]);
		int c=Integer.parseInt(st[2]);
		int ans=0;
		for (int i=n-1; i>=0; i--){
			int t = 1<<i;
			if (r<t){
				if (c>=t){
					ans += t*t;
					c-=t;
				}
			} else if (c<t) {
				ans += t*t*2;
				r -= t;
			} else {
				ans += t*t*3;
				r -= t;
				c -= t;
			}
		}
		System.out.println(2*r+c+ans);
	}
}
