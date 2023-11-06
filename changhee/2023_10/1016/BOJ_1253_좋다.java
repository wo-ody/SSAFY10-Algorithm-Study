import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int nums[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int answer = 0;
        for(int i=0; i<N; i++) {
            int target = nums[i];
            int start = 0, end = N-1;

            while(start < end) {
                int sum = nums[start] + nums[end];

                if(sum == target) {
                    if(start != i && end != i) {
                        ++answer;
                        break;
                    } else if(start == i) {
                        ++start;
                    } else {
                        --end;
                    }
                } else if(sum < target) {
                    ++start;
                } else {
                    --end;
                }
            }
        }

        System.out.println(answer);
    }
}
