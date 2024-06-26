import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] w = new int[n][3]; 
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            w[i][0] = a + b;
            w[i][1] = a + c;
            w[i][2] = b + c;
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