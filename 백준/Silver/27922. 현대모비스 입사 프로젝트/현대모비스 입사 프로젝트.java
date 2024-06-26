import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr  = new int[n][3]; //역량
        int[][] w = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

            w[i][0] = arr[i][0] + arr[i][1];
            w[i][1] = arr[i][0] + arr[i][2];
            w[i][2] = arr[i][1] + arr[i][2];
        }

        int answer = 0;
        int tmp[] = new int[n];
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                tmp[j] = w[j][i];
            }
            Arrays.sort(tmp);
            int sum=0;
            for(int j=1; j<=k; j++){
                sum+=tmp[n-j];
            }
            answer = answer < sum ? sum : answer;
        }
        System.out.println(answer);

    }
}