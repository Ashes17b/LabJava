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
                Scanner lineFirst = new Scanner(input.nextLine());
                if (input.hasNextLine()) {
                    Scanner lineSecond = new Scanner(input.nextLine());
                    String first = findMaxLengthSubstring(lineFirst);
                    String second = findMaxLengthSubstring(lineSecond);

                    if (first.length() > second.length())
                        second = first;

                    String result = new String(second);

                    System.out.println("Result: " + result);
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String findMaxLengthSubstring(Scanner line) {
        int max = 0;
        String temp = new String();

        while (line.hasNext()) {
            String s = line.next();
            if (s.length() > max) {
                max = s.length();
                temp = s;
            }
        }

        return temp;
    }
}
