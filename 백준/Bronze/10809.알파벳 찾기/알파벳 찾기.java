import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		int[]          arr = new int[26];
		String         str = br.readLine();
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i) - 'a'] == -1) {
				arr[str.charAt(i) - 'a'] = i;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}
}