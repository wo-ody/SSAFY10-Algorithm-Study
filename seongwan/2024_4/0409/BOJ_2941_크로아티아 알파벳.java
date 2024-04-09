import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans;

    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            ans++;
            if (i == 0)
                continue;

            char temp = s.charAt(i);
            char prev = s.charAt(i - 1);

            //비교하면서 =이 나왔을 때
            //나올 수 있는 크로아티아 알파벳 처리
            if (temp == '=') {
                if (prev == 'c' || prev == 's')
                    ans--;
                else if (prev == 'z') {
                    ans--;
                    if (i != 1 && s.charAt(i - 2) == 'd')
                        ans--;
                }
            }

            if (temp == '-' && (prev == 'c' || prev == 'd'))
                ans--;

            if (temp == 'j' && (prev == 'l' || prev == 'n'))
                ans--;
        }
        System.out.println(ans);
    }
}