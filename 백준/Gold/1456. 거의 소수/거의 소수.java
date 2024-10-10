import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int max_len = 10000000;

        boolean[] isNotPrime = new boolean[max_len + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(max_len); i++) {
            if (isNotPrime[i]) continue;
            for (int j = i + i; j <= max_len; j += i) {
                isNotPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i <= max_len; i++) {
            if (!isNotPrime[i]) {
                long tmp = (long) i * i;  // 소수의 제곱으로 초기화
                while (tmp <= max) {
                    if (tmp >= min) {
                        count++;
                    }
                    if (tmp > max / i) break;  // 오버플로우 방지
                    tmp *= i;
                }
            }
        }
        System.out.println(count);
    }
}
