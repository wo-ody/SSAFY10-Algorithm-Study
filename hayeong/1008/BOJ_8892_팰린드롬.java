import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_8892_팰린드롬 {
    static int T, N;
    static ArrayList<String> result;

    static String[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new String[N];
            result = new ArrayList<>();
            // 입력
            for (int i = 0; i < N; i++) {
                list[i] = br.readLine();
            }
            // 붙여서 팰린드롬인지 확인
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    
                    String tmp = list[i] + list[j];
                    int start = 0;
                    int end = tmp.length() - 1;
                    boolean isPalin = true;
                    while (start < end) {
                        if (tmp.charAt(start) != tmp.charAt(end)) {
                            isPalin = false;
                            break;
                        }
                        start++;
                        end--;
                    }
                    if (isPalin) {
                        result.add(tmp);
                    }
                }
            }
            

            if (result.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(result.get(0));
            }
        }
    }
}
