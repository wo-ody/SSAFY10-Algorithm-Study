import java.io.*;
import java.util.*;
public class BOJ_1331_나이트투어 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<String> set = new HashSet<>();
		char[] bf = br.readLine().toCharArray(), af;
		char[] start = bf.clone();
		set.add(bf[0]+""+bf[1]);
		int a; boolean flag=true;
		for (int i=0; i<35; i++) {
			af = br.readLine().toCharArray();
			a= Math.abs(bf[0]-af[0]);
			if (a!=1 && a!=2) flag=false;
			a+= Math.abs(bf[1]-af[1]);
			if (a!=3) flag=false;
			bf[0] = af[0]; bf[1] = af[1];
			set.add(bf[0]+""+bf[1]);
		}
		a= Math.abs(bf[0]-start[0]);
		if (a!=1 && a!=2) flag=false;
		a+= Math.abs(bf[1]-start[1]);
		if (a!=3) flag=false;
		if (set.size()!=36) flag = false;
		if (flag) System.out.println("Valid");
		else System.out.println("Invalid");
	}
}
