
import java.util.Scanner;
public class BOJ_1057_토너먼트{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Kim = sc.nextInt();
        int Lim = sc.nextInt();

        int cnt = 1;
        while (N>1) {
        	if(Kim%2 == 1 && Kim + 1 == Lim || Lim%2 == 1 && Lim + 1 == Kim){
        		System.out.println(cnt);
        	}
        	cnt += 1;
        	Kim = (Kim+1)/2;
        	Lim = (Lim+1)/2;
        	N = (N%2 == 0)?N/2 : N/2+1;
        }
        
    }
}