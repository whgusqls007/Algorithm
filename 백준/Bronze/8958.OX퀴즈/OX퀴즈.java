import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw       = new BufferedWriter(new OutputStreamWriter(System.out));
		int            N        = Integer.parseInt(br.readLine());
		char[]         arr      = null;
		int            cnt      = 0;
		int            sum      = 0;
		char           prevChar = 'A';
		char           curChar  = 'A';
		for (int i = 0; i < N; i++) {
			arr      = br.readLine().toCharArray();
			curChar  = arr[0];
			prevChar = arr[0];
			if (curChar == 'O') {
				cnt = 1;
				sum = 1;
			} else {
				cnt = 0;
				sum = 0;
			}
			for (int j = 1; j < arr.length; j++) {
				curChar = arr[j];
				if (curChar == 'O' && prevChar == 'O') {
					cnt++;
					sum += cnt;
				} else if (curChar == 'O' && prevChar == 'X') {
					cnt  = 1;
					sum += cnt;
				}
				prevChar = curChar;
			}
			bw.write(sum + "\n");
		}
		bw.flush();

	}
}