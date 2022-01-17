package koinot.com.bot.enums;

public enum TypeOfFuel {
    PETROL("" ,"PETROL", "БЕНЗИН","BENZIN","👍"),
    DIZEL("","DIZEL", "ДИЗЕЛЬ","DIZEL","👍"),
    ELECTRIC("", "ELECTRIC", "ЭЛЕКТРИЧЕСТВО","ELEKTRIK","👍"),
    HYBRID("GAS/BENZIN, ELEKTIK/BENCIN","HYBRID","ГИБРИД","GIBRID","👍"),
    GAS("METAN/PROPAN","GAS","ГАЗ","GAZ","👍");


    private String titleRu;
    private String titleUz;
    private String titleEn;
    private String description;
    private String icon;

    TypeOfFuel(String description,String titleEn,String titleRu,String titleUz,String icon) {
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
