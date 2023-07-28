import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[9];
        
        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
        }

        int max = 0;
        int max_idx = 0;
        for (int i = 0; i < 9; i++) {
            if(max < nums[i]){
                max = nums[i];
                max_idx = i;
            }
        }
        System.out.println(max);
        System.out.println(max_idx+1);
    }
}
