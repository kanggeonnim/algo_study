import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ6603 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);

      // 0을 입력받으면 종료
      if (n == 0) {
        break;
      }

      // n크기의 배열 생성후 옮겨담기
      int[] array = new int[n];
      boolean visited = new boolean[n];

      for (int i = 0; i < n; i++) {
        array[i] = Integer.parseInt(input[i+1]);
      }

      find(array, visited, 0, n);


    }

  }
  public static void find(int[] array, boolean[] visited, int start, int r) {
    if(r == 0){
      print(arr, visited);
      return;
    }    

    for(int i = start; i < array.length; i++){
      visited[i] = true;
      find(array, visited, i+1, r-1);
      visitid[i] = false;
    }
  }

  public static void print(int[] array, boolen[] visited){
    for(int i = 0; i < visited.length; i++){
      if(visited[i]){
        System.out.printf(array[i] + " ");
      }
    }
    System.out.println();
  }
}
