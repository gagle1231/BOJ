import java.util.*;

public class Main {

	public static void main(String[] args){
		int N, M;
		int[] arr = new int[20000001];
		int n;

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();

		for(int i=0; i<N; i++) {
			n = sc.nextInt();
			arr[n+10000000]++;
		}

		M = sc.nextInt();

		for(int i=0; i<M; i++) {
			n = sc.nextInt();
			sb.append(arr[n+10000000]+" ");
		}
		System.out.println(sb);
	}
}