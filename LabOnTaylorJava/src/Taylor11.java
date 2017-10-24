public class Taylor11 {
    public static void main(String[] argc){
        double x = Double.parseDouble(argc[0]);
        int eps_n = Integer.parseInt(argc[1]);
        double true_result = (Math.exp(x) - Math.exp(-x)) / 2;
        System.out.printf("Result by Math: %." + eps_n +"f\n", true_result);

        double eps = Math.pow(10, -eps_n);
        double a = x;
        double res = x;
        for(int n = 3; Math.abs(a) >= eps; n+=2){
            a = a * x * x / ((n - 1) * n);
            res += a;
        }
        System.out.printf("\nResult by Taylor: %." + eps_n + "f\n", res);
    }
}
