import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = Long.valueOf(st.nextToken());
        long b = Long.valueOf(st.nextToken());
        long g = gcd(a, b);

        for(long d=0; d<g; d++){
            bw.write('1');
        }
        bw.flush();
    }

    public static long gcd(long a, long b) {
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
