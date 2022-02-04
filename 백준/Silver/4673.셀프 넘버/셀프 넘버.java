public class Main {
	public static int self(int num) {
		int sum = num;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int selfnum = self(i);
			if (selfnum <= 10000) {
				arr[selfnum] = true;
			}
		}
		for (int i = 1; i <= 10000; i++) {
			if (!arr[i]) {
				System.out.println(i);
			}
		}
	}
}