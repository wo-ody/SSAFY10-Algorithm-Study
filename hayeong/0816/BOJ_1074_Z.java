import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

	static int N, r, c;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		
		find(size, r, c);
		
		System.out.println(cnt);
		
		
		
	}
	
	static void find(int size, int r, int c) {
		if(size == 1) return;
		
		if(r < size/2 && c< size/2) {
			find(size/2, r,c);
		}
		else if(r<size/2 && c >= size/2) {
			cnt += size * size / 4;
			find(size/2 , r, c - size/2 );
		}
		else if(r>=size/2 && c<size/2) {
			cnt += (size * size / 4) *2;
			find(size/2, r-size/2, c);
		} 
		else {
			cnt += (size * size / 4) *3;
			find(size/2, r-size/2, c-size/2);
		}
	}

}
