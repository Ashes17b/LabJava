import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class String6 {
    private static final String FILE_PATH = "input";

    public String6() {
    }

    public static void main(String[] argc) {
        try {
            if (argc.length != 1) {
                System.err.println("Invalidate number of arguments!");
                System.exit(1);
            }

            double x = Double.parseDouble(argc[0]);
            Scanner in = new Scanner(new File(FILE_PATH));
            if (!in.hasNextLine()) {
                System.err.println("Empty file: input");
            }

            while (in.hasNextLine()) {
                String str = in.nextLine();
                double res = x;
                int index = str.indexOf("/");
                while (index != -1) {
                    if (str.charAt(index - 1) == 'x') {
                        int next_index;
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(index + 1, next_index));
                        double tmp = x / cons;
                        str = str.substring(0, index - 1) + Double.toString(tmp) + str.substring(next_index);
                    } else if (str.charAt(index + 1) == 'x') {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(next_index, index));
                        cons /= x;
                        str = str.substring(0, next_index + 1) + Double.toString(cons) + str.substring(index + 2);
                    } else {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }
                        int save_index = next_index;
                        double cons = Double.parseDouble(str.substring(next_index, index));
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }
                        cons /= Double.parseDouble(str.substring(index + 1, next_index));
                        str = str.substring(0, save_index) + Double.toString(cons) + str.substring(next_index);
                    }
                    index = str.indexOf("/");
                }

                index = str.indexOf("*");
                while (index != -1) {
                    if (str.charAt(index - 1) == 'x') {
                        int next_index;
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(index + 1, next_index));
                        cons *= x;
                        str = str.substring(0, index - 1) + Double.toString(cons) + str.substring(next_index);
                    } else if (str.charAt(index + 1) == 'x') {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(next_index, index));
                        cons *= x;
                        str = str.substring(0, next_index + 1) + Double.toString(cons) + str.substring(index + 2);
                    } else {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }
                        int save_index = next_index;
                        double cons = Double.parseDouble(str.substring(next_index, index));
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }
                        cons *= Double.parseDouble(str.substring(index + 1, next_index));
                        str = str.substring(0, save_index) + Double.toString(cons) + str.substring(next_index);
                    }
                    index = str.indexOf("*");
                }

                index = str.indexOf("-");
                while (index != -1) {
                    if (str.charAt(index - 1) == '-') {
                        int next_index;
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(index + 1, next_index));
                        double tmp = x - cons;
                        str = str.substring(0, index - 1) + Double.toString(tmp) + str.substring(next_index);
                    } else if (str.charAt(index + 1) == 'x') {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(next_index, index));
                        cons -= x;
                        str = str.substring(0, next_index + 1) + Double.toString(cons) + str.substring(index + 2);
                    } else {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }
                        int save_index = next_index;
                        double cons = Double.parseDouble(str.substring(next_index, index));
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }
                        cons -= Double.parseDouble(str.substring(index + 1, next_index));
                        str = str.substring(0, save_index) + Double.toString(cons) + str.substring(next_index);
                    }
                    index = str.indexOf("-");
                }

                index = str.indexOf("+");
                while (index != -1) {
                    if (str.charAt(index - 1) == 'x') {
                        int next_index;
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(index + 1, next_index));
                        cons += x;
                        str = str.substring(0, index - 1) + Double.toString(cons) + str.substring(next_index);
                    } else if (str.charAt(index + 1) == 'x') {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }

                        double cons = Double.parseDouble(str.substring(next_index, index));
                        cons += x;
                        str = str.substring(0, next_index + 1) + Double.toString(cons) + str.substring(index + 2);
                    } else {
                        int next_index;
                        for (next_index = index - 1; next_index > 0 && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; --next_index) {
                        }
                        int save_index = next_index;
                        double cons = Double.parseDouble(str.substring(next_index, index));
                        for (next_index = index + 1; next_index < str.length() && str.charAt(next_index) != '+'
                                && str.charAt(next_index) != '-' && str.charAt(next_index) != '*' && str.charAt(next_index) != '/'; ++next_index) {
                        }
                        cons += Double.parseDouble(str.substring(index + 1, next_index));
                        str = str.substring(0, save_index) + Double.toString(cons) + str.substring(next_index);
                    }
                    index = str.indexOf("+");
                }

                System.out.println(str);
            }
        } catch (FileNotFoundException var13) {
            var13.getMessage();
        } catch (NumberFormatException var14) {
            var14.getMessage();
        }

    }
}