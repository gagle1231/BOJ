import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열을 순열로 생성
        permute(arr, 0, n);

        System.out.println(maxSum);
    }

    // 순열을 구하는 함수
    static void permute(int[] arr, int depth, int n) {
        if (depth == n) {
            int currentSum = calculateDifference(arr);
            maxSum = Math.max(maxSum, currentSum);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1, n);
            swap(arr, depth, i);
        }
    }

    // 두 배열 요소를 바꾸는 함수
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 인접한 요소들의 차이의 절댓값 합 계산
    static int calculateDifference(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }
}
