import java.util.*;
public class Main {

	public static void 부정행위 멈춰(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n=sc.nextInt(),m=sc.nextInt();
		if (n==1 && m==1) sb.append(1).append("\n").append(1);
		else if (n==1) {
			sb.append(2).append("\n");
			int a=0;
			for (int i=0;i<m;i++) {sb.append(a+1).append(" "); a^=1;}
		} else if (m==1) {
			sb.append(2).append("\n");
			int a=0;
			for (int i=0;i<n;i++) {sb.append(a+1).append("\n"); a^=1;}
		} else {
			sb.append(4).append("\n");
			int a=0, b=0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					sb.append(a+b*2+1).append(" ");
					a^=1;
				}
				sb.append("\n");
				b^=1;
			}
		}
		System.out.println(sb);
	}
}
