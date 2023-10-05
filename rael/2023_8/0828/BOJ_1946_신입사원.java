import java.util.Scanner;

public class BOJ_1946_신입사원 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int count = 1;
            int work[] = new int[m+1];
            for(int j=0; j<m; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                work[a] = b;
            }

            int vot = work[1];

            for(int j=2; j<=m; j++){
                if(work[j]<vot){
                    vot = work[j];
                    count++;

                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}