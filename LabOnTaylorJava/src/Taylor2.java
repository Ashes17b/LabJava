public class Taylor2 {
    public static void main(String[] argc) {
        double x = Double.parseDouble(argc[0]);
        int eps_n = Integer.parseInt(argc[1]);
        if (x >= 1 || x <= -1) {
            System.err.println("Incorrect X!");
            System.exit(1);
        }
        double true_result = 1 / Math.pow(1 + x, 3);
        System.out.printf("Result by Math: %." + eps_n + "f\n", true_result);

        double eps = Math.pow(10, -eps_n);
        double a = 1;
        double res = 1;
        for (int n = 2; Math.abs(a) >= eps; n++) {
            if (a == 1)
                a *= -x * n * (n + 1) / 2;
            else
                a *= -x * (n + 1) / (n - 1);
            res += a;
        }
        System.out.printf("\nResult by Taylor: %." + eps_n + "f\n", res);
    }
}
