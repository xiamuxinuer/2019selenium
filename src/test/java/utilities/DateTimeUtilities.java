package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {
    public static String getTodaysDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
}
