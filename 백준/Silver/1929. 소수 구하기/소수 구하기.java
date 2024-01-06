import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n, m;

		n=sc.nextInt();
		m=sc.nextInt();
		boolean[] arr = new boolean[m+1];
		
		arr[1] = true; 
		
		for(int i=2; i<=m; i++) {
			if(arr[i]==true)
				continue;
			
			for(int j=2*i; j<=m; j+=i)
				arr[j]=true;
		}
		
		for(int i=n; i<=m; i++)
			if(!arr[i])
				sb.append(i+"\n");
		
		System.out.print(sb);
		sc.close();
	}
}