import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_11536_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        String[] temp = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            if (!arr[i].equals(temp[i])) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("INCREASING");
        else {
            Arrays.sort(temp, Collections.reverseOrder());
            flag = true;
            for (int i = 0; i < N; i++) {
                if (!arr[i].equals(temp[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println("DECREASING");
            else System.out.println("NEITHER");
        }
    }
}
