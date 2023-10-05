import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();  // 스트링 빌더 사용하지 않고 출력하고 시간 초과남
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();  // list 생성
        
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());  // 입력받은 값 list에 추가
        
        Collections.sort(arr);  // Arrays.sort()보다 Collections.sort()가 더 빠르다고 함
        
        for(int i : arr)
          sb.append(i).append('\n');
        
		System.out.println(sb);
    }
}
