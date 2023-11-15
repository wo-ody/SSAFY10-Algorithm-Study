import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int y, m, d;
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int yy, mm, dd;
		st = new StringTokenizer(br.readLine());
		yy = Integer.parseInt(st.nextToken());
		mm = Integer.parseInt(st.nextToken());
		dd = Integer.parseInt(st.nextToken());
		if (yy-y>1000||(yy-y==1000&&mm>m)||(yy-y==1000&&mm==m&&dd>=d)) {
			System.out.println("gg");
		}else {
			System.out.println("D-"+(f(yy,mm,dd)-f(y,m,d)));
		}
	}
	
	static int[] dayArray(int year) {
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			day[1] = 29;
		return day;
	}

	static long f(int year, int month, int day) {
		long days = 0;
		int[] date;
		for (int i = 1; i < year; i++) {
			date = dayArray(i);
			for (int j = 0; j < 12; j++) {
				days += date[j];
			}
		}
		date = dayArray(year);
		for (int i = 0; i < month-1; i++) {
			days += date[i];
		}
		days += day;
		return days;
	}
}
