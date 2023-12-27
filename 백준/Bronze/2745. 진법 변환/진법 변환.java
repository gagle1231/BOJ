import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int digit = Integer.parseInt(st.nextToken());
        int x = 1;
        int result = 0;
        for(int i=n.length()-1; i>=0; i--){
            int a = n.charAt(i) - '0';
            if(a>=10) a -= 7;
            result += x*a;
            x *= digit;
        }
        System.out.println(result);
    }
}