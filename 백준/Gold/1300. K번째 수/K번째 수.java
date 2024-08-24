import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = (long)n * n;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            // count the number of elements <= mid
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
