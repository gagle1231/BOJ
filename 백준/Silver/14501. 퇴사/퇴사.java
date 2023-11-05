import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] t; //상담 소요 날짜
    static int[] p; //상담하고 받는 돈
    static int[] b; //백트래킹용
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        b = new int[n];

        String s;
        StringTokenizer st;

        for(int i=0; i<n; i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max = solution(0, n);
        System.out.println(max);
    }
    public static int solution(int idx, int n){
        if(idx >= n) return 0;
        int p1 = 0;
        if(idx + t[idx] <= n){
            p1 = solution(idx + t[idx], n) + p[idx];
        }
        int p2 = solution(idx+1, n);
        b[idx] = p1 > p2 ? p1: p2;
        return b[idx];
    }
}