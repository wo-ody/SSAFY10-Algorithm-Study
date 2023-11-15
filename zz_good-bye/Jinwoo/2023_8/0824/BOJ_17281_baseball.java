import java.io.*;
import java.util.*;
public class BOJ_17281_baseball {
	static int n, ans;
	static int[][] toto;
	static boolean[] field;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		toto= new int[n][9];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) toto[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] t = new int[9];
		perm(1,0, t);
		
		System.out.println(ans);
	}

	static void perm(int sel, int cnt, int[] selec){
		if (9==cnt) {
			ans = Math.max(ans, game(selec));
		}
		if (cnt==3) cnt++;
		for (int i=1; i<9; i++) {
			if ((sel&(1<<i)) ==0) {selec[cnt]=i; perm(sel|(1<<i), cnt+1, selec);}
		}
	}
	
	static int game(int[] selec) {
		int score=0, out, now, hit, nowin=0;

		for (int i=0; i<n; i++) {
			out=0;
			field = new boolean[3];
			while (out<3) {
				now = selec[nowin++];
				nowin%=9;
				hit = toto[i][now];
				switch (hit) {
				case (0) : out++; break;
				case (1) : 
					if (field[2]) score++; 
					field[2]=field[1]; 
					field[1] = field[0]; 
					field[0] = true; 
					break;
				case (2) : 
					if (field[2]) score++; if (field[1]) score++;
					field[2] = field[0]; 
					field[1] = true; 
					field[0] = false; 
					break;
				case (3) :
					if (field[2]) score++; if (field[1]) score++; if (field[0]) score++;
					field[2] = true;
					field[1] = false; 
					field[0] = false; 
					break;
				case (4) :
					if (field[2]) score++; if (field[1]) score++; if (field[0]) score++; score++;
					field = new boolean[3];
				}
			}
		}
		return score;
	}
	
}
