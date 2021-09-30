package parenkov.header;

public enum HeaderMenuItem {
    DEVELOPMENT("Разработка"),
    ADMIN("Администрирование"),
    DESIGN("Дизайн"),
    MANAGEMENT("Менеджмент"),
    MARKETING("Маркетинг"),
    POPSCIENCE("Научпоп");

    private String desc;

    HeaderMenuItem(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
