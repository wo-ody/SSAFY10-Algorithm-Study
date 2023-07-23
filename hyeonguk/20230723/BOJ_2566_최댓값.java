import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[9][9];
		int maxNum = 0;
		int idxI = 0;
		int idxJ = 0;
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= maxNum) {
					maxNum = arr[i][j];
					idxI = i;
					idxJ = j;
				}
			}
		}

		System.out.println(maxNum);
		System.out.println((idxI+1)+" "+(idxJ+1));
	}

}
