import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchWord {
    public static void main(String[] args) {
        String s = "hòa";
        int res = 0;
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            String tmp;
            while ((tmp = br.readLine()) != null){
                if(tmp.contains(s)){
                    ++res;
                    System.out.println("Line: " + res);
                    System.out.println(tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
