public class Taylor6 {
    public static void main(String[] argc) {
        double x = Double.parseDouble(argc[0]);
        int eps_n = Integer.parseInt(argc[1]);
        double true_result = Math.cos(x);
        System.out.printf("Result by Math: %." + eps_n + "f\n", true_result);

        double eps = Math.pow(10, -eps_n);
        double a = 1;
        double res = 1;
        for (int n = 2; Math.abs(a) >= eps; n += 2) {
            a = -1 * a * x * x / ((n - 1) * n);
            res += a;
        }
        System.out.printf("\nResult by Taylor: %." + eps_n + "f\n", res);
    }
}
