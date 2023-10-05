
public class BOJ_4673_셀프넘버 {
	
//	https://www.acmicpc.net/problem/4673
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		boolean[] check = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			int n = go(i);
			
			if( n <= 10001 ) {
				check[n] = true;
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(!check[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
	
	static int go(int n) {
		int sum = n;
		
		while( n > 0 ) {
			sum += (n % 10);
			n /= 10;
		}
		
		return sum;
	}
	
	

}
