package koinot.com.bot.enums;

public enum TransportCondition {
    GREAT("","GREAT","ОТЛИЧНОЕ","IDEAL","👍"),
    GOOD("","GOOD","ХОРОШЕЕ","YAXSHI","👍"),
    MEDIUM("","MEDIUM","СРЕДНЕЕ","O'RTACHA","👍"),
    BAD("","BAD","ТРЕБУЕТ РЕМОНТА","TA'MIR TALAB","👍");


    private String titleRu;
    private String titleUz;
    private String titleEn;
    private String description;
    private String icon;

    TransportCondition(String description,String titleEn,String titleRu,String titleUz,String icon) {
        this.titleRu=titleRu;
        this.titleUz=titleUz;
        this.titleEn=titleEn;
        this.description=description;
        this.icon=icon;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public String getTitleUz() {
        return titleUz;
    }

    public String getTitleEn() {
        return titleEn;
    }


    public String getDescription() {
        return description;
    }

}
