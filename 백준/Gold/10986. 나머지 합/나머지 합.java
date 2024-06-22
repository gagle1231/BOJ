import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sub = new long[n+1];
        long[] cs = new long[m]; // 배열 크기를 m으로 수정
        long cnt = 0; // cnt를 long으로 수정
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            sub[i] = sub[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            int remain = (int)(sub[i]%m);
            if(remain == 0) cnt++;
            cs[remain]++;
        }
        for(int i=0; i<m; i++){
            if(cs[i]>1)
                cnt += cs[i] * (cs[i] - 1) / 2;
        }
        System.out.println(cnt);
    }
}
