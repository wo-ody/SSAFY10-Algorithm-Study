import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r, c;

        int[][] arr = new int[n+1][n+1];

        for(int i=1; i<=m; i++){
            r = sc.nextInt();
            c = sc.nextInt();
            arr[r][c] = 1;
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i+1][j+1] + " ");
            }
            System.out.println();
        }
    }
}
