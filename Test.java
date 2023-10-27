
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Test {
    public static void main(String[] args) {
        String dateString1 = "15-03-2023"; // example date string 1
        String dateString2 = "23-03-2023"; // example date string 2

        // convert the date strings to date objects using DateUtil class
        Date date1 = DateUtil.convertStringToDate(dateString1);
        Date date2 = DateUtil.convertStringToDate(dateString2);

        // calculate the number of days between the two dates
        long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        // print the result
        System.out.println("Number of days between " + dateString1 + " and " + dateString2 + " is: " + diffInDays);
    }
}
