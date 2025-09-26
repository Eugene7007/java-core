package lessons.lesson03.enums;

public enum Currency {
    UZS(2, "Валюта Узбекистана"),
    EUR(2, "Валюта стран Европейского союза"),
    USD(2, "Валюта США");

    final int scale;
    final String description;

    Currency(int scale, String description) {
        this.scale = scale;
        this.description = description;
    }

    @Override
    public String toString() {
        return "scale=" + scale + ", description='" + description;
    }
}
