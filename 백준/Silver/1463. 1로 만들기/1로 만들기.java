import java.util.*;

public class Main {

	public static int solution(int a[], int n) {

		if(a[n]!=0)
			return a[n];

		if(n==1) return 0;
		if(n==2||n==3)
			return a[n] = 1;
		else if(n%6==0)
			return a[n] = Math.min(Math.min(solution(a, n/3),solution(a, n/2)), solution(a, n-1)) + 1;
		else if(n%3==0)
			return a[n] = Math.min(solution(a, n-1),solution(a, n/3)) + 1;
		else if(n%2==0)
			return a[n] =  Math.min(solution(a, n-1), solution(a, n/2)) + 1;
		else
			return a[n] = solution(a, n-1) + 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] a = new int[n+1];

		
		System.out.println(solution(a, n));

	}
}