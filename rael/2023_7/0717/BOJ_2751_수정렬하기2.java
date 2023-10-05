import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
	
		for(int i = 0; i < num; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);

		for(Integer c : list) {
			sb.append(c).append("\n");
		}
		
		System.out.println(sb);
	}
}


//아래 구문은 시간 초과가 뜬 구문
/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] nums = new int[num];

        for(int i=0; i<num; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}*/
