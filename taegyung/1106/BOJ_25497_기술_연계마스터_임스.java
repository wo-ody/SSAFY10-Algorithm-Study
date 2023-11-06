package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25497_기술_연계마스터_임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char [] commands = br.readLine().toCharArray();

        int flagL = 0;
        int  flagS =0 ;

        int cnt = 0;
        for(int i = 0 ; i < N ; i ++){
            if (commands[i] == 'L') {
                flagL +=1;
                continue;
            }

            if (commands[i] == 'S') {
                flagS += 1;
                continue;
            }

            if (commands[i] == 'R'){
                if ( flagL > 0) {
                    flagL -= 1;
                    cnt++;
                }
                else{
                    break;
                }
                continue;
            }

            if (commands[i] == 'K'){
                if ( flagS > 0) {
                    flagS -= 1;
                    cnt++;

                }
                else{
                    break;
                }
                continue;

            }

            cnt ++;
        }
        System.out.println(cnt);

    }


}
