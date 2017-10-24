public class Time {
    protected int hour;
    protected int minute;

    public int getHour() { return hour; }
    public int getMinute() { return minute; }

    public Time() {
        hour = 12;
        minute = 0;
    }

    public Time(int hour, int minute) throws IllegalArgumentException {
        if (hour >= 1 && hour <= 23)
            this.hour = hour;
        else
            throw new IllegalArgumentException();
        if (this.minute >= 0 && this.minute <= 59)
            this.minute = minute;
        else
            throw new IllegalArgumentException();
    }

    public String toString() {
        String s = "";
        if ( hour < 10 && minute < 10)
            s = "0" + hour + "0" + minute;
        else if ( hour < 10 && minute > 10)
            s = "0" + hour + minute;
        else if ( hour > 10 && minute < 10)
            s = hour + "0" + minute;
        else if ( hour == 0)
            s = "0" + hour + minute;
        else if ( minute == 0)
            s = hour + "0" + minute;

        return s;

    }
}
