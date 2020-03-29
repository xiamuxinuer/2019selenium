package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {
    public static String getTodaysDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public  static long  getTimeDifference(String startTime,String endTime,String format){
        LocalTime start=LocalTime.parse(startTime,DateTimeFormatter.ofPattern(format));
        LocalTime end=LocalTime.parse(endTime,DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(start,end);
    }

}
