package algorithms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class test202007006 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();

        cal.set(cal.DAY_OF_WEEK, cal.SUNDAY);
        cal.set(Calendar.DATE, cal.get(cal.DATE) -1);
        String weeklast = sdf.format(cal.getTime());
        System.out.println(weeklast);
    }
}
