import java.util.*;

public class Main {

	public static int solution(int a[], int n) {
		a[0] = a[1] = 1;
		
		for(int i=2; i<=n; i++) {
			a[i] = a[i-1] + a[n-2];
		}
		return a[n]%10007;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] a = new int[n+1];

		
		System.out.println(solution(a, n));

	}
}
