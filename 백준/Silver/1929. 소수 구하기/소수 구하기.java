import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(arr[i]) continue;
            for(int j=2; i*j<=n; j++) {
                arr[i*j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=m; i<=n; i++) {
            if(!arr[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
