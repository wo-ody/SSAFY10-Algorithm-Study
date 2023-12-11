import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 1, start_index = 1, end_index = 1;
        int count = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            } else if (sum > N) {   // 줄이기
                sum -= start_index;
                start_index++;
            } else { 
                end_index++;  //늘리기
                sum += end_index;
            }
        }

        System.out.println(count);
    }

}
