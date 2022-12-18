import java.util.*;
public class Main {
	static int powerSet(int[] arr, boolean[] picked, int s, int target, int k) {
		int cnt=0;
		
		if(k==arr.length) {
			if(s==target)
				return 1;
			else
				return 0;
		}
		
		picked[k] = false;
		cnt+=powerSet(arr, picked, s, target, k+1);
		picked[k] = true;
		cnt+=powerSet(arr, picked, s+arr[k], target, k+1);
		
		
		return cnt;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		
		boolean []pick = new boolean[arr.length];

		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		int count = powerSet(arr, pick, 0, s, 0);
		
		if(s!=0)
			System.out.println(count);
		else
			System.out.println(count-1); //공집합까지 카운트하는 경우
	}
}