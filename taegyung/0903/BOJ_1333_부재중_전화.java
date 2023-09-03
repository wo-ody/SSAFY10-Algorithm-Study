package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1333_부재중_전화
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int time = 0;

//        while (true){
//            time += N;

//        }

        boolean flag = false;
        for(int i = 0 ; i < N ; i ++){
            if(flag)
                break;
            time += L;
            for(int j = 0 ; j  < 5 ; j ++){

                if (time%D==0){
                    System.out.println(time);
                    flag = true;
                    break;
                }
                time += 1;
            }
        }
        if (!flag){
//            System.out.println()
            for(int i = 0 ; i < 2*D; i ++){

                if (time % D== 0) {
                    System.out.println(time);
                    break;
                }
                time += 1;
            }
        }

    }
}
