import java.util.Scanner;

public class 시험감독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] classes = new int[n];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            classes[i] = sc.nextInt();
        }

        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i < n; i++) {
            classes[i] -= b;
            sum++;
            if (classes[i] > 0) {
                sum += (classes[i] / c );
            }
            if(classes[i]%c >0){
                sum++;
            }
        }

        System.out.println(sum);
    }
}
