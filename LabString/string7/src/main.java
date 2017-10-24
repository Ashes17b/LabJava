import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
            //System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);
	        System.out.print("Input expression: ");

            //File file = new File(input.nextLine());

            //input = new Scanner(System.in);

            //Checking on empty file
            if (!input.hasNextLine()) {
                throw new Exception("File is empty!");
            }

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    //System.out.println(line);
                    if (!line.equals(""))
                        System.out.println("Result: " + eval(line));
	    	    System.out.print("Input expression: ");
                }
                input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int priority(char oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        }
        else if(oper == '+' || oper == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    public static void letGo(List<Integer> st, char oper) {

        int someOne = st.remove(st.size() - 1);

        int someTwo = st.remove(st.size() - 1);

        switch(oper) {
            case '+':
                st.add(someTwo + someOne);
                break;
            case '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Error");
        }
    }

    public static int eval(String s) {
        List<Integer> someInts = new ArrayList<Integer>();
        List<Character> someOpers = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c == '(')
                someOpers.add('(');
            else if (c == ')') {
                while(someOpers.get(someOpers.size() - 1) != '(') {
                    letGo(someInts, someOpers.remove(someOpers.size() - 1));
                }
                someOpers.remove(someOpers.size() - 1);
            }
            else if (isOperator(c)) {
                while(!someOpers.isEmpty() &&
                        priority(someOpers.get(someOpers.size() - 1)) >= priority(c)) {
                    letGo(someInts, someOpers.remove(someOpers.size() - 1));
                }
                someOpers.add(c);
            }
            else {
                String operand = "";
                while(i < s.length() &&
                        Character.isDigit(s.charAt(i))) {
                    operand += s.charAt(i++);
                }
                --i;
                someInts.add(Integer.parseInt(operand));
            }
        }
        while(!someOpers.isEmpty()) {
            letGo(someInts, someOpers.remove(someOpers.size() - 1));
        }

        return someInts.get(0);
    }
}
