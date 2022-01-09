package koinot.com.bot.entity.enums;

/**
 * @className: Msg  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 6:39 AM $
 * @author: Qudratjon Komilov
 */
public enum Msg {

//    HELLO ("hi how are you"),
    HELLO ("hi how are you");


    private String title;

    Msg(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }

}
