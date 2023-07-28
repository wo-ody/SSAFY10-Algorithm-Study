import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visit[];
	static int n, m, v;	
	static int count = 0;
	
	public static int dfs(int i) {
		visit[i] = true;
		for(int k : arr[i]) {
			if(visit[k] == false) {
				count ++;
				dfs(k);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();	
		v = 1;	// 탐색 시작 정점 번호
		arr = new ArrayList[n+1];	
		visit = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();	
			arr[u].add(v);
			arr[v].add(u);
		}
		System.out.println(dfs(v));
		scan.close();       //자원 반납
	}
}