import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25757_임스와함께하는미니게임 {
    static int N,ans,cnt;
    static char c;
    static HashSet<String> name = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        c = st.nextToken().charAt(0);

        switch (c) {
            case 'Y' :
                cnt = 0;
                for (int i = 0; i < N; i++) {
                    String str = br.readLine();
                    if (!name.contains(str)) {
                        name.add(str);
                        cnt++;
                        if (cnt == 1){
                            ans++;
                            cnt = 0;
                        }
                    }
                }
                break;

            case 'F' :
                cnt = 0;
                for (int i = 0; i < N; i++) {
                    String str = br.readLine();
                    if (!name.contains(str)) {
                        name.add(str);
                        cnt++;
                        if (cnt == 2){
                            ans++;
                            cnt = 0;
                        }
                    }
                }
                break;

            case 'O' :
                cnt = 0;
                for (int i = 0; i < N; i++) {
                    String str = br.readLine();
                    if (!name.contains(str)) {
                        name.add(str);
                        cnt++;
                        if (cnt == 3){
                            ans++;
                            cnt = 0;
                        }
                    }
                }
                break;
        }
        System.out.println(ans);

    }
}
