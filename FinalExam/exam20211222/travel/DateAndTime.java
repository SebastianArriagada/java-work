package exam20211222.travel;

public class DateAndTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }

    public DateAndTime(int year,int month,int day,int hour, int minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public DateAndTime(){
        this(2021, 12, 22, 04, 30);
    }
    @Override
    public String toString(){
        String date = this.year + "." + this.month + "." + this.day + " at " + this.hour + ":" + this.minute ; 
        return date;
    }

    public String getTime(){
        String time = this.hour + ":" + this.minute;
        return time; 
    }
    
}
