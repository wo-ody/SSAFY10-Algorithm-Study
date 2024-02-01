import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_26069_붙임성좋은총총이 {
    static HashSet<String> set = new HashSet<>();
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if (set.contains(name1)|set.contains(name2)){
                set.add(name1);
                set.add(name2);
            }
        }

        System.out.println(set.size());
    }
}
