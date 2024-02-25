import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String accept = "is acceptable.";
    static final String not = "is not acceptable.";
    static char[] mo = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;
            sb.append("<").append(str).append("> ");
            int cnt = 0;
            int mCnt = 0;//모음 연속
            int jCnt = 0;//자음 연속
            boolean flag = true;
            char pre = ' ';
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == pre && c != 'e' && c!='o' ) {
                    flag = false;
                    break;
                }
                pre = c;
                boolean mCheck = false;
                for (int j = 0; j < 5; j++) {
                    if (c == mo[j]) {
                        mCheck = true;
                        cnt++;
                        mCnt++;
                        jCnt = 0;
                        if (mCnt == 3) flag = false;
                        break;
                    }
                }
                if (!mCheck){
                    jCnt++;
                    mCnt = 0;
                    if(jCnt == 3) {
                        flag = false;
                        break;
                    }
                }

            }
            if (cnt == 0 || !flag) {
                sb.append(not).append("\n");
            }else {
                sb.append(accept).append("\n");
            }
        }
        System.out.println(sb);

    }
}
