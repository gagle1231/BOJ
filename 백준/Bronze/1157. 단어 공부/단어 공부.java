import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            Integer n = map.get(c);
            if(n == null){
                map.put(c, 1);
            }else{
                map.put(c, n+1);
            }
        }
        int max = 0;
        char result = '?';
        for(Map.Entry<Character, Integer> c: map.entrySet()){
            int v = c.getValue();
            if(v > max) {
                result = c.getKey();
                max = v;
            }else if(max == v)
                result = '?';
        }
        System.out.println(result);
    }
}