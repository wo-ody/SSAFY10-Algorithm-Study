import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][];

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                arr[i] = new int[j+1];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    arr[i][j] = 1;
                }
                else if(i==j){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
