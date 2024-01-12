import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_11478_서로다른부분문자열의개수 {
    static HashSet<String> set = new HashSet<>();
    static String S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        for(int i=1; i<=S.length(); i++) { //부분문자열 길이
            for(int j=0; j<=S.length()-i; j++) { //시작 인덱스
                set.add(S.substring(j,i+j));
            }
        }

        System.out.println(set.size());

    }
}
