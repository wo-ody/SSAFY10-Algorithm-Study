package boj;

public class BOJ_4673_셀프넘버 {
	static boolean[] visit = new boolean[20000];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		for(int i=1; i<9999; i++) {
			int num = 0;
			int n = i;
			num += n;
			
			while(n>0) {
				num += n%10;
				n /= 10;
			}
			
			visit[num] = true;
		}
		
		for(int i=1; i<10000; i++) {
			if(!visit[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

}
