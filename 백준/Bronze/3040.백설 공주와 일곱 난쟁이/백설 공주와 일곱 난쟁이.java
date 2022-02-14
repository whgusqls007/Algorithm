import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] arr  = new int[9];
	static int[] arr2 = new int[9];
	static int   len  = 8;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr2 = Arrays.copyOf(arr, 9);

		Arrays.sort(arr);

		breakPoint: while (np()) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += arr[i];
				if (sum == 100) {
					break breakPoint;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 7; j++) {
				if (arr2[i] == arr[j]) {
					bw.write(arr2[i] + "\n");
					break;
				}
			}
		}
		bw.flush();
	}

	static boolean np() {
		int i = len;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = len;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

		swap(i - 1, j);
		int k = len;

		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}