import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class array9 {
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size Matrix: ");

        try {
            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[n][n];
            Random r = new Random();
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = r.nextInt(2 * n + 1) - n;

            System.out.println("Source Matrix:");
            outputArray(matrix);

            task(matrix);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }

    public static void task(int[][] arr) {
        int rowToRemove = 0;
        int colToRemove = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    rowToRemove = i;
                    colToRemove = j;
                }
            }
        }

        arr = removeCol(arr, colToRemove);
        arr = removeRow(arr, rowToRemove);
        if(!checkingZero(arr)) {
            System.out.println("Result Matrix:");
            outputArray(arr);
            return;
        }
        task(arr);
    }

    private static boolean checkingZero(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (arr[i][j] == 0)
                    return true;
        return false;
    }

    private static int[][] removeCol(int [][] array, int colRemove) {
        int row = array.length;
        int col = array[0].length;

        int [][] newArray = new int[row][col-1]; //new Array will have one column less

        for(int i = 0; i < row; i++)
            for(int j = 0,currColumn=0; j < col; j++)
                if(j != colRemove)
                    newArray[i][currColumn++] = array[i][j];

        return newArray;
    }

    private static int[][] removeRow(int [][] array, int rowRemove) {
        int[][] newArray = new int[array.length - 1][];
        System.arraycopy(array, 0, newArray, 0, rowRemove);
        System.arraycopy(array, rowRemove + 1, newArray, rowRemove,
                array.length - rowRemove - 1);

        return newArray;
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