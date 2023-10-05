import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {
    static int N, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[] up = new int[N/2];
        int[] down = new int[N/2];

        for(int i = 0; i<N/2; i++){
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int h = 1; h<=H; h++){
            int conflict = bs(0, N/2, h, down) + bs(0, N/2, H-h+1, up);
            if(conflict == min){
                cnt++;
            } else if(conflict < min){
                min = conflict;
                cnt = 1;
            }
        }
        System.out.println(min+" "+cnt);

    }

    static int bs(int start, int end, int height, int[] arr){
        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid]>=height){
                end = mid;
            } else{
                start = mid+1;
            }
        }
        return arr.length - end;
    }
}
