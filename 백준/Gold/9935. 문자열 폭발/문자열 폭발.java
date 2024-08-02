import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bump = br.readLine();
        int n = bump.length();
        ArrayList<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()){
            list.add(c);
            boolean find = true;
            if(list.size() >= n){
                for(int i=0; i<n; i++){
                    if(bump.charAt(i) != list.get(list.size() - n + i)){
                        find = false;
                        break;
                    }
                }
                if(find){
                    for(int i=0; i<n; i++){
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        if(list.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(char c: list){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
