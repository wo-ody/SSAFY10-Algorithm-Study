import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            // 1. N개의 옷 입력 받기
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hash.put(type, hash.getOrDefault(type, 0) + 1);
            }

            // 2. 전체 경우의 수 계산하여 출력
            int answer = 1;
            for(int val : hash.values())
                answer *= val + 1;
            bw.write(String.valueOf(answer - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
