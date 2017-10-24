public class Taylor13 {
    public static void main(String[] argc){
        double x = Double.parseDouble(argc[0]);
        int eps_n = Integer.parseInt(argc[1]);

        if (argc.length != 2) {
          System.err.println("Invalid number of arguments");
          System.exit(1);
        }
        
        if(x >= 1 || x <= -1)
        {
            System.err.println("Incorrect X!");
            System.exit(1);
        }
        double true_result = Math.asin(x);
        System.out.printf("Result by Math: %." + eps_n +"f\n", true_result);

        double eps = Math.pow(10, -eps_n);
        double a = x;
        double res = x;
        for(int n = 1; Math.abs(a) >= eps; n++){
            a=x*x*(a*(2*n-1))/(2*n);
            a=a/(2*n+1);
            res += a;
        }
        System.out.printf("\nResult by Taylor: %." + eps_n + "f\n", res);
    }
}
