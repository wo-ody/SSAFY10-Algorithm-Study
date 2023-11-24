import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20187_종이접기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k = Integer.parseInt(st.nextToken()); // 한 변의 길이가 2k인 정사각형의 크기
        char[] a = new char[31];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * k; i++) {
            a[i] = st.nextToken().charAt(0); // 종이를 접는 방법을 나타내는 문자열
        }
        
        int[][] ans = new int[2005][2005]; // 구멍이 뚫린 위치를 저장할 배열
        ans[0][0] = Integer.parseInt(br.readLine()); // 구멍을 뚫는 위치
        
        int x = 1, y = 1; // 초기 x와 y의 크기
        
        // 종이를 접는 방법에 따라 구멍이 뚫리는 위치를 계산
        for (int i = 2 * k - 1; i >= 0; i--) {
            if (a[i] == 'L') {
                // 왼쪽으로 접는 경우, 구멍 위치 조정
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[j][2 * y - 1 - z] = ans[j][z] ^ 1;
                    }
                }
                y *= 2;
            } else if (a[i] == 'R') {
                // 오른쪽으로 접는 경우, 구멍 위치 조정
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[j][z + y] = ans[j][z];
                    }
                }
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[j][z] = ans[j][2 * y - 1 - z] ^ 1;
                    }
                }
                y *= 2;
            } else if (a[i] == 'D') {
                // 아래로 접는 경우, 구멍 위치 조정
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[j + x][z] = ans[j][z];
                    }
                }
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[j][z] = ans[2 * x - 1 - j][z] ^ 2;
                    }
                }
                x *= 2;
            } else if (a[i] == 'U') {
                // 위로 접는 경우, 구멍 위치 조정
                for (int j = 0; j < x; j++) {
                    for (int z = 0; z < y; z++) {
                        ans[2 * x - 1 - j][z] = ans[j][z] ^ 2;
                    }
                }
                x *= 2;
            }
        }

        // 펼쳐진 종이에서 구멍의 위치 출력
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
