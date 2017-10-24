import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class array7 {
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size Matrix: ");

        try{
            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[n][n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = r.nextInt(2*n + 1) - n;

            System.out.println("Source Matrix: ");
            outputArray(matrix);

            task(matrix);

            System.out.println("Result Matrix:");
            outputArray(matrix);

        } catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
    }

    public static void task(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int average = averageScore(arr, i);
            for (int j = 0; j < arr.length; j++)
                arr[i][j] -= average;
        }
    }

    private static int averageScore(int[][] arr, int i) {
        int sum = 0;
        for (int j = 0; j < arr.length; j++)
            sum += arr[i][j];
        return sum / arr.length;
    }

    public static void outputArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
