import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static StringTokenizer st;
static int[][] map= new int[5][5];
static int[] dr = {-1,0,1,0};
static int[] dc = {0,-1,0,1};
static Set<Integer> set = new HashSet<>();
static int[] tgt=new int[6];
	public static void main(String[] args)throws Exception {
		for (int i = 0; i < 5; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,0);
			}
		}
		System.out.println(set.size());

	}
	static void dfs(int r, int c,int cnt) {
		if(cnt==6) {
			set.add(tgt[0]*100000+tgt[1]*10000+tgt[2]*1000+tgt[3]*100+tgt[4]*10+tgt[5]);
		return;
	}
		tgt[cnt]=map[r][c];
		for (int dir = 0; dir < 4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr>=0&&nr<5&&nc>=0&&nc<5) {
				dfs(nr,nc,cnt+1);
			}
		}
     }

}
