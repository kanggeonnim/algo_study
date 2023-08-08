import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // [][][0] -> 가로
        // [][][1] -> 세로
        // [][][2] -> 대각선
        int[][][] array2 = new int[N + 1][N + 1][3];
        array2[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 해당칸의 가로합 구하기
                if (array[i][j] != 1) {
                    array2[i][j][0] += array2[i][j - 1][0] + array2[i][j - 1][2];
                    array2[i][j][1] += array2[i - 1][j][1] + array2[i - 1][j][2];
                    array2[i][j][2] += array2[i - 1][j - 1][0] + array2[i - 1][j - 1][1] + array2[i - 1][j - 1][2];
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(Arrays.toString(array2[i][j]));
            }
            System.out.println();
        }


    }
}
