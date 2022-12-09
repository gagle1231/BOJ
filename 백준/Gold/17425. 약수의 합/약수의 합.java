import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long[] g = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException{
		int T, N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] fn = new int[1000001];
		
		for(int i=1; i<1000001; i++) {
			for(int j=1; i*j<1000001; j++)
				fn[i*j]+=i;
			g[i] = g[i-1] + fn[i];
		}
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(g[N]+"\n");
		}
		System.out.println(sb);		
	}
}