import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            max   = Integer.MIN_VALUE;
		int            num   = 0;
		int            index = 0;
		for (int i = 0; i < 9; i++) {
			num = Integer.parseInt(br.readLine());

			if (num > max) {
				max   = num;
				index = i + 1;
			}
		}

		System.out.println(max);
		System.out.println(index);
	}
}
