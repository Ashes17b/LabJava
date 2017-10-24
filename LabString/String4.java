import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class String4 {
    private static final String FILE_PATH = "input";
    public static void main(String[] argc){
        try {
            Scanner in = new Scanner(new File(FILE_PATH));
            if(!in.hasNextLine()){
                System.err.println("Empty file: " + FILE_PATH);
            }
            while(in.hasNextLine()){
                StringBuilder str = new StringBuilder();
                str.append(in.nextLine());
                StringBuilder new_str = new StringBuilder();
                int count = 0;
                for(int i = 1; i < str.length(); i++){
                    if(str.charAt(i-1) == str.charAt(i)){
                        count++;
                    }else {
                        if (count == 0){
                            new_str.append(str.charAt(i-1));
                        }else {
                            new_str.append(str.substring(i-1, i) + Integer.toString(count + 1));
                            count = 0;
                        }
                    }
                }
                System.out.println(new_str);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
