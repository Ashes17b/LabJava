import java.io.File;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);

            //Checking on empty file
            if (!input.hasNextLine()) {
                throw new Exception("File is empty!");
            }

            while (input.hasNextLine()) {
                Scanner word = new Scanner(input.nextLine());

                String line = new String();
                while (word.hasNext()) {
                        String s = word.next();
                        if(s.length() > 1)
                            line += s + " ";
                    }

                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}