package studyAuthenticating;

import java.util.*;
import java.io.*;

public class BOJ_2775_부녀회장이_될테야 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++){
			int row = Integer.parseInt(br.readLine())+1;
			int col = Integer.parseInt(br.readLine());
			int[][] lst = new int[row][col];
			for(int i = 0; i < col; i++) lst[0][i] = i+1;
			
			for(int i = 1; i < row; i++){
				for(int j = 0; j < col; j++){
					int result = 0;
					for(int k = 0; k <= j; k++){
						result += lst[i-1][k] ;
					}
					lst[i][j] = result;
				}
			}
			System.out.println(lst[row-1][col-1]);
			
		}
	}
}
