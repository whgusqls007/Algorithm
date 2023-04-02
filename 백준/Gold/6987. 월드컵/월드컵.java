import java.io.*;
import java.util.*;

public class Main {
    static int[][] table;
    static int[][] result;
    static int[][] matches = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
            { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        table = new int[6][3];
        result = new int[6][3];

        for (int n = 0; n < 4; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 6; i++) {
                table[i][0] = Integer.parseInt(st.nextToken());
                table[i][1] = Integer.parseInt(st.nextToken());
                table[i][2] = Integer.parseInt(st.nextToken());
            }

            if (!preCheck()) {
                bw.write("0 ");
                continue;
            }

            result = new int[6][3];

            if (!dfs(0)) {
                bw.write("0 ");
                continue;
            }

            bw.write("1 ");
        }
        bw.flush();
    }

    public static boolean dfs(int match) {
        boolean rv = false;
        if (match == 15) {
            return check();
        }

        int team1 = matches[match][0];
        int team2 = matches[match][1];

        result[team1][0]++;
        result[team2][2]++;
        rv = dfs(match + 1);
        result[team1][0]--;
        result[team2][2]--;

        if (rv) {
            return rv;
        }

        result[team1][2]++;
        result[team2][0]++;
        rv = dfs(match + 1);
        result[team1][2]--;
        result[team2][0]--;

        if (rv) {
            return rv;
        }

        result[team1][1]++;
        result[team2][1]++;
        rv = dfs(match + 1);
        result[team1][1]--;
        result[team2][1]--;

        return rv;
    }

    public static boolean check() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean preCheck() {
        int wins = 0;
        int draws = 0;
        int loses = 0;
        for (int i = 0; i < 6; i++) {
            wins += table[i][0];
            draws += table[i][1];
            loses += table[i][2];
            if (table[i][0] + table[i][1] + table[i][2] != 5) {
                return false;
            }
        }

        if (wins + draws + loses != 30) {
            return false;
        }

        return true;
    }
}
