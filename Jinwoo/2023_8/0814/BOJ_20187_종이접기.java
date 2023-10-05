import java.io.*;
import java.util.Arrays;
public class BOJ_20187_종이접기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader로 입력받기위해 생성
		int k = Integer.parseInt(br.readLine()); // 종이 접은 횟수
		String[] fold = br.readLine().split(" "); // 접은 방법 기록하는 배열 입력
		int[][] paper = {{Integer.parseInt(br.readLine())}}; // 종이 상태 저장 변수
		for (int i=2*k-1; i>=0; i--) {
			paper = unfold(paper, paper.length, paper[0].length, fold[i]); // 종이 펴기 함수
		}
		StringBuilder sb = new StringBuilder(); // 출력 Stringbuilder
		for (int i=0; i<1<<k; i++) { 
			for (int j=0; j<1<<k; j++) { //paper의 i, j에 대하여 sb에 저장
				sb.append(paper[i][j]).append(" ");
			}
			sb.append("\n"); // 한줄마다 줄바꿈
		}
		System.out.println(sb);// 출력
	}

	public static int[][] unfold(int[][] paper, int r, int c, String durl){ // 대칭을 입력하는 순서를 잘못 정했다.. if문이 아니라 for문에서 나눠야 했다
		int[][] ans; // return할 이중배열 선언   위아래 대칭은 xor 3, 좌우 대칭은 xor 1로 계산할 수 있다.
		if (durl.equals("R")) { // 오른쪽으로 접은 것은 왼쪽이 대칭이다.
			ans = new int[r][c<<1];
			for (int i=0;i<r;i++) {
				for (int j=0;j<c<<1;j++) {
					if (j<c) ans[i][j] = paper[i][c-j-1]^1; // 이렇게 바꾸면 잘 될거같다.. 시간부족
					else ans[i][j] = paper[i][j-c];
				}
			}
		}else if (durl.equals("L")){// 왼쪽으로 접은 것은 오른쪽이 대칭이다.
			ans = new int[r][c<<1];
			for (int i=0;i<r;i++) {
				for (int j=0;j<c<<1;j++) {
					if (j>=c) ans[i][j] = paper[i][2*c-j-1]^1;
					else ans[i][j] = paper[i][j];
				}
			}
		}else if (durl.equals("U")){// 위쪽으로 접은 것은 아래쪽이 대칭이다.
			ans = new int[r<<1][c];
			for (int i=0;i<r<<1;i++) {
				for (int j=0;j<c;j++) {
					if (i>=r) ans[i][j] = paper[2*r-i-1][j]^2;
					else ans[i][j] = paper[i][j];
				}
			}
		}else{// 아래쪽으로 접은 것은 위쪽이 대칭이다.
			ans = new int[r<<1][c];
			for (int i=0;i<r<<1;i++) {
				for (int j=0;j<c;j++) {
					if (i<r) ans[i][j] = paper[r-i-1][j]^2;
					else ans[i][j] = paper[i-r][j];
				}
			}
		}
		return ans;
	}
}
