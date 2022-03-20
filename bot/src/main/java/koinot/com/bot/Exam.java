package koinot.com.bot;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class Exam {
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        System.out.println(timeStamp);
    }

    public static boolean isFormatFirstLastName(String text) {
        if (!text.startsWith("+test*")) return false;
        if (text.trim().split("\\*").length != 3) return false;
        return true;
    }

}
