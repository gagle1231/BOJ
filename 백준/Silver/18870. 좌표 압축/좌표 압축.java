import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> map = new HashMap<>();
	
		int i=0;
		for(int a: sorted) {
			if(!map.containsKey(a))
				map.put(a, i++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a: arr) {
			sb.append(map.get(a)+" ");
		}
		System.out.println(sb);
	}
}