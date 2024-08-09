import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 1;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 1; right <= n; right++) {
            sum += arr[right];

            while (sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
