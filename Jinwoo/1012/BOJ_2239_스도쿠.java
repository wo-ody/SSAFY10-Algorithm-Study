import java.io.*;
import java.util.*;
public class Main {
	static char[][] table = new char[9][9];
	static boolean[][][] v = new boolean[9][9][10];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<9; i++) {
			table[i] = br.readLine().toCharArray();
		}
		int t;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (table[i][j] != '0') {
					t = table[i][j] - '0';
					for (int k=0; k<9; k++) {v[k][j][t] = true; v[i][k][t] = true;}
					for (int r=i/3*3; r<i/3*3+3; r++) {
						for (int c=j/3*3; c<j/3*3+3; c++) v[r][c][t] = true;
					}
				}
			}
		}
		bt();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) sb.append(table[i]).append("\n");
		System.out.println(sb);
	}
	
	static boolean bt() {
		for (int i=0; i<9; i++) {
			for (int j= 0; j<9; j++) {
				if (table[i][j]=='0') {
					for (int k=1; k<10; k++) {
						if (v[i][j][k] || !isValid(i, j, (char)(k+'0'))) continue;
						table[i][j] = (char) (k+'0');
						if (bt()) return true;
						table[i][j] = '0';
					}
					if (table[i][j]=='0') return false;
				}
			}
		}
		return true;
	}
	
	static boolean isValid(int r, int c, char num) {
		for (int i=0; i<9; i++) if (table[r][i]==num || table[i][c]==num) return false;
		for (int i=r/3*3; i<r/3*3+3; i++) {
			for (int j=c/3*3; j<c/3*3+3;j++) if (table[i][j]==num) return false;
		}
		return true;
	}
}
