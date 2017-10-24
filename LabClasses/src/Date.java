import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Date extends Time {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date() {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        java.util.Date x = currentDate.getTime();
        SimpleDateFormat formatdd = new SimpleDateFormat("dd");
        this.day = Integer.parseInt(formatdd.format(x));
        SimpleDateFormat formatmonth = new SimpleDateFormat("MM");
        this.month = Integer.parseInt(formatmonth.format(x));
        SimpleDateFormat formatyear = new SimpleDateFormat("yyyy");
        this.year = Integer.parseInt(formatyear.format(x));
        SimpleDateFormat formathour = new SimpleDateFormat("HH");
        this.hour = Integer.parseInt(formathour.format(x));
        SimpleDateFormat formatminute = new SimpleDateFormat("mm");
        this.minute = Integer.parseInt(formatminute.format(x));
    }

    public Date(int day, int month, int year, int hour, int minute) throws IllegalArgumentException{
        super(hour, minute);
        if (!isValid(day, month, year)) throw new IllegalArgumentException();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(String date) throws IllegalArgumentException {
        String[] s = date.split("-");
        if (s.length != 5) throw new IllegalArgumentException();
        int dd = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int yy = Integer.parseInt(s[2]);
        int h = Integer.parseInt(s[3]);
        int m = Integer.parseInt(s[4]);
        if (!isValid(dd, mm, yy)) throw new IllegalArgumentException();
        this.year = yy;
        this.month = mm;
        this.day = dd;
        this.hour = h;
        this.minute = m;
    }

    public boolean compareTo(Date d) {
        int day1 = d.getDay();
        int month1 = d.getMonth();
        int year1 = d.getYear();
        int hour1 = d.getHour();
        int minute1 = d.getMinute();
        return (this.year <= year1) && (this.month <= month1) && (this.day <= day1) &&
                (this.hour <= hour1) && (this.minute <= minute1);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.day < 10) s.append("0");
        s.append(String.valueOf(this.day));
        s.append("-");
        if (this.month < 10) s.append("0");
        s.append(String.valueOf(this.month));
        s.append("-");
        s.append(String.valueOf(this.year));

        s.append(" Time ");
        s.append(String.valueOf(getHour()));
        s.append(":");
        s.append(String.valueOf(getMinute()));
        return s.toString();
    }

    public static boolean isLeap(int year) {
        // using system library to do this, avoid re-invent the wheel
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public static boolean isValid(int day, int month, int year) {
        if (year < 0) return false;
        if ((month < 1) || (month > 12)) return false;
        if ((day < 1) || (day > 31)) return false;
        switch (month) {
            case 1: return true;
            case 2: return (isLeap(year) ? day <= 29 : day <= 28);
            case 3: return true;
            case 4: return day < 31;
            case 5: return true;
            case 6: return day < 31;
            case 7: return true;
            case 8: return true;
            case 9: return day < 31;
            case 10: return true;
            case 11: return day < 31;
            default: return true;
        }
    }
}
