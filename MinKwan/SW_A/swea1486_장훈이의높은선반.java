import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1486_장훈이의높은선반 {

    static int T;
    //N은 학생수, B는 기준 탑의 높이
    static int N,B;
    static int[] people;
    static int[] set;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t= 1; t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            set = new int[N];
            people = new int[N];
            visit = new boolean[N];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<N;i++){
                people[i] = Integer.parseInt(st.nextToken());
            }


            subset(0,0);

            System.out.println("#"+t+" "+min);
        }
    }

    static void subset(int cnt, int sum){

      if(sum>=B){
          min = Math.min(min,Math.abs(sum-B));
          return;
      }

      if(cnt==N)
          return;

        visit[cnt] = false;
        subset(cnt+1, sum);
        visit[cnt] = true;
        subset(cnt +1,sum+people[cnt]);

    }
}