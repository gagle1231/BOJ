import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] p = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
			p[i] =arr[i];
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				p[i] = Math.min(p[i], p[i-j]+arr[j]);
			}
		}
		System.out.println(p[n]);
	}

}