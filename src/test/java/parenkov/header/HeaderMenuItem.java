package parenkov.header;

public enum HeaderMenuItem {
    DEVELOPING("Разработка"),
    DESIGN("Дизайн"),
    POPSCIENCE("Научпоп");

    private String desc;

    HeaderMenuItem(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
