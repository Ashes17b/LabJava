public class Taylor10 {
    public static void main(String[] argc){
        double x = Double.parseDouble(argc[0]);
        int eps_n = Integer.parseInt(argc[1]);
        if (x => 1 || x <= -1)
        {
            System.err.println("Incorrect X!");
            System.exit(1);
        }
        double true_result = Math.log((1 + x) / (1 - x));
        System.out.printf("Result by Math: %." + eps_n +"f\n", true_result);

        double eps = Math.pow(10, -eps_n);
        double a = x * 2;
        double res = x * 2;
        for(int n = 3; Math.abs(a) >= eps; n += 2){
            a = a * x * x * (n - 2) / n;
            res += a;
        }
        System.out.printf("\nResult by Taylor: %." + eps_n + "f\n", res);
    }
}
