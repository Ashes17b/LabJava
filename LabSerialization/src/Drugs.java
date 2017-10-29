import java.io.*;
import java.util.*;

public class Drugs {
    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].compareTo("-a") == 0) {
                    System.out.println("Append file with new object from System.in");
                    append_file();
                }
                else if (args[0].compareTo("-p") == 0) {
                    System.out.println("Prints data file:");
                    print_file();
                }
                else if (args[0].compareTo("-d") == 0) {
                    System.out.println("Delete data file");
                    delete_file();
                }
                else {
                    System.err.println("Option is not realised: " + args[0]);
                    System.exit(1);
                }
            }
            else {
                System.err.println("Drugs: edit configuration(arguments)!");
            }
        }
        catch (Exception e) {
            System.err.println("Run/time error: " + e);
            System.exit(1);
        }
        System.out.println("Drugs compile successful");
	System.exit(0);
    }

    static final String filename = "Drugs.dat";
	
    private static Scanner fin = new Scanner(System.in);

    static Drug read_drug() {
        if (fin.hasNextLine()) {
            return Drug.read(fin);
        }
        return null;
    }
	
    static void delete_file() {
        File f = new File(filename);
        f.delete();
    }
	
    static void append_file() throws FileNotFoundException, IOException {
        Drug drug;
        System.out.println("Enter drug data: ");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            while ((drug = read_drug()) != null) {
                Buffer.writeObject(raf, drug);
	        }
        }
    }

    static void print_file() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            while ((pos = raf.getFilePointer()) < raf.length()) {
                Drug drug = (Drug)Buffer.readObject(raf, pos);
                System.out.println(pos + ": " + drug);
            }
        }		
    }
}
