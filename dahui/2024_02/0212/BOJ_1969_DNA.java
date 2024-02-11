import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1969_DNA {
    static int[][] ACGT; //각 자리에서의 ACGT의 수
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ACGT = new int[4][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                switch (c) {
                    case 'A':
                        ACGT[0][j]++;
                        break;
                    case 'C':
                        ACGT[1][j]++;
                        break;
                    case 'G':
                        ACGT[2][j]++;
                        break;
                    case 'T':
                        ACGT[3][j]++;
                        break;
                }
            }
        }
        int hammingSum = 0;

        for (int j = 0; j < M; j++) {
            int maxIndex = 0;
            for (int i = 1; i < 4; i++) {
                if (ACGT[i][j] > ACGT[maxIndex][j]) {
                    maxIndex = i;
                }
            }
            switch (maxIndex) {
                case 0: sb.append('A'); break;
                case 1: sb.append('C'); break;
                case 2: sb.append('G'); break;
                case 3: sb.append('T'); break;
            }
            hammingSum += N - ACGT[maxIndex][j];
        }

        sb.append("\n").append(hammingSum);
        System.out.println(sb);
    }
}
