public class Test {
    public static void main(String[] args) {
        // get today
        Date today = new Date();
        System.out.println("Today: " + today.toString());
        System.out.println("Compare today with today: " + today.compareTo(today)); // today is today
        System.out.println();

        // tomorrow
        Date tomorrow = new Date("06-10-2017-12-11");
        System.out.println("Tomorrow: " + tomorrow.toString());
        System.out.println("Compare tomorrow with today: " + today.compareTo(tomorrow)); // today is earlier than tomorrow
        System.out.println();

        // yesterday
        Date yesterday = new Date(4, 10, 2017, 11, 32);
        System.out.println("Yesterday: " + yesterday.toString());
        System.out.println("Compare yesterday with today: " + today.compareTo(yesterday)); // today is NOT earlier than tomorrow
        System.out.println();

        // 2017 is not leap year
        System.out.println(Date.isLeap(2017) ? "2017 is leap": "2017 is not leap");
        System.out.println();

        // 31-9-2017 is a valid date
        System.out.println("isValid Date: " + Date.isValid(31, 9, 2017));
        System.out.println();

        // 29-10-2017-31-43 is not valid and will throw IllegalArgumentException
        Date invalid = new Date(29, 10, 2017, 31, 43); // throws exception
        System.out.println("isValid Date: " + invalid.toString());
    }
}
