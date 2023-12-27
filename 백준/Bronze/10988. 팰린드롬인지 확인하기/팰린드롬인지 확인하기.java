import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int l = str.length();
        int isPalindrome = 1;
        for(int i=0; i<l/2; i++){
            if(str.charAt(i) != str.charAt(l-1-i)){
                isPalindrome = 0;
            }
        }
        System.out.println(isPalindrome);
    }
}