package koinot.com.bot.enums;

/**
 * @className: Msg  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 6:39 AM $
 * @author: Dostonbek Ibragimov
 */
public enum Msg {

//    HELLO ("hi how are you"),
    HELLO ("hi how are you","aster start"),
    HELLO_CHOOSE_A_LANGUAGE ("aster start","\uD83C\uDDEC\uD83C\uDDE7 hello choose a language","\uD83C\uDDFA\uD83C\uDDFF salom til tanlang","\uD83C\uDDF7\uD83C\uDDFA привет выберите язык");





































    private String titleRu;
    private String titleUz;
    private String titleEn;
    private String description;

    Msg(String description,String titleEn,String titleRu,String titleUz) {
        this.titleRu=titleRu;
        this.titleUz=titleUz;
        this.titleEn=titleEn;
        this.description=description;
    }

    Msg(String description,String titleEn) {
        this.titleEn=titleEn;
        this.description=description;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public String getTitleUz() {
        return titleUz;
    }

    public void setTitleUz(String titleUz) {
        this.titleUz=titleUz;
    }

    public String getTitleEn() {
        return titleEn;
    }


    public String getDescription() {
        return description;
    }

}
