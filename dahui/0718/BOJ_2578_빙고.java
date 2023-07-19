import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][5];
		boolean[][] checkArr = new boolean[5][5];
		int call = 0;
		int ans = 0;
		boolean[] lineCheck = new boolean[12];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for(int k=0; k<25; k++) {
			call = sc.nextInt();
			//불렀는지 빙고판에 체
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(call == arr[i][j]) {
						checkArr[i][j] = true;
					}
				}
			}
			
			//가로줄 빙고 체크 
			for(int i=0; i<5; i++) {
				int check = 0;
				for(int j=0; j<5; j++) {
					if(checkArr[i][j] == true) {
						check++;
					}
				}
				if(check==5) {
					lineCheck[i] = true;
				}
			}
			
			//세로줄 빙고 체크 
			for(int i=0; i<5; i++) {
				int check = 0;
				for(int j=0; j<5; j++) {
					if(checkArr[j][i] == true) {
						check++;
					}
				}
				if(check==5) {
					lineCheck[i+5] = true;
				}
			}
			
			//대각선 줄 체크1 
			int check = 0;
			for(int i=0; i<5; i++) {
				if(checkArr[i][i] == true) {
					check++;
				}
				if(check==5) {
					lineCheck[10] = true;
				}
			}
			//대각선 줄 체크2  
			check = 0;
			for(int i=0; i<5; i++) {
				if(checkArr[i][4-i] == true) {
					check++;
				}
				if(check==5) {
					lineCheck[11] = true;
				}
			}
			
			int cnt = 0;
			for(int i=0; i<12; i++) {
				if(lineCheck[i] == true) {
					cnt++;
				}
			}
			
			if( cnt>=3 ) {
				ans = k+1;
				break;
			}
			
		}
		
		System.out.println(ans);

	}

}
