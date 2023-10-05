public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[10001];
		for (int i = 0; i < 10001; i++) {
			numbers[i] = i;
		}

		for (int i = 1; i < 10001; i++) {
			if (numbers[i] == 0)
				continue;
			int self = i;
			while (self < 10001) {
				self = selfNumber(self);
				if(self < 10001) {
					numbers[self] = 0;
				}
			}
		}
		
		for(int i=1; i < 10001; i++) {
			if(numbers[i] != 0) System.out.println(numbers[i]);
		}
	}

	static int selfNumber(int num) {
		int res = num;
		while (num != 0) {
			res += (num % 10);
			num /= 10;
		}
		return res;
	}
}
