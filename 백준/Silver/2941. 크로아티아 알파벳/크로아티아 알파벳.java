import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("c=", "a");
        str = str.replaceAll("c-", "a");
        str = str.replaceAll("dz=", "a");
        str = str.replaceAll("d-", "a");
        str = str.replaceAll("lj", "a");
        str = str.replaceAll("nj", "a");
        str = str.replaceAll("s=", "a");
        str = str.replaceAll("z=", "a");

        System.out.println(str.toCharArray().length);
    }
}