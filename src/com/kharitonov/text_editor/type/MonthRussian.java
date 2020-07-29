package com.kharitonov.text_editor.type;

public enum MonthRussian {
    JANUARY(1, "ЯНВАРЬ"),
    FEBRUARY(2, "ФЕВРАЛЬ"),
    MARCH(3, "МАРТ"),
    APRIL(4, "АПРЕЛЬ"),
    MAY(5, "МАЙ"),
    JUNE(6, "ИЮНЬ"),
    JULY(7, "ИЮЛЬ"),
    AUGUST(8, "АВГУСТ"),
    SEPTEMBER(9, "СЕНТЯБРЬ"),
    OCTOBER(10, "ОКТЯБРЬ"),
    NOVEMBER(11, "НОЯБРЬ"),
    DECEMBER(12, "ДЕКАБРЬ");

    private final int index;
    private final String value;

    MonthRussian(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    public static MonthRussian getMonth(String value) {
        MonthRussian monthRussian=null;
        MonthRussian []months = values();
        value=value.toUpperCase();
        for (MonthRussian month : months) {
            if (month.value.equals(value)) {
                monthRussian=month;
                break;
            }
        }
        return monthRussian;
    }
}
