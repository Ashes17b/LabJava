import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class String5 {
    private static final String FILE_PATH = "input";
    public static void main(String[] argc){
        try {
            Scanner in = new Scanner(new File(FILE_PATH));
            if(!in.hasNextLine()){
                System.err.println("Empty file: " + FILE_PATH);
            }
            while (in.hasNextLine()) {
                StringBuilder max_str = new StringBuilder();
                int max_len = -1;
                String str = in.nextLine();
                int count = 0;
                for(int i = 1; i < str.length(); i++) {
                    if (str.charAt(i - 1) == str.charAt(i)) {
                        count++;
                    } else {
                        if(max_len < ++count){
                            max_str.delete(0, max_str.length());
                            for(int j =0; j < count; j++)
                                max_str.append(str.substring(i-1, i));
                            max_len = count;
                            count = 0;
                        }
                    }
                }
                System.out.println(max_str);
            }
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }
    }
}
