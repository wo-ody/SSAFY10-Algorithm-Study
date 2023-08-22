import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;

        String[] cal = br.readLine().split("-"); // 빼기를 기준으로 분리
        int res = 0;
        for(int i=0;i < cal.length;i++) {
            int sum = 0;
            String[] cal2 = cal[i].split("\\+");
            for(int j=0;j<cal2.length;j++) {
                sum += Integer.parseInt(cal2[j]);
            }
            if(i==0) {
                res += sum;
            }else {
                res -= sum;
            }
        }
        System.out.println(res);
        
    }
}