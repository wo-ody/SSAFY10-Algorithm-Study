import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double x, y, c, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		
		double start = 0;
		double end = Math.min(x, y);
		
		while(start <= end) {
			double mid = (start+end)/2;
			
			double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
			double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));
			
			double tmp = (h1*h2)/(h1 + h2);
			
			if(tmp < c) {
				end = mid-0.0001;
			}else {
				start = mid+0.0001;
				answer = mid;
			}
		}
		System.out.printf("%.3f", answer);
	}
}
