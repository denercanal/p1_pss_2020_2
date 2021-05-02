package br.ufes.dener.p1_pss_2020_2.model;

import java.util.List;
import java.util.stream.Collectors;

public enum TipoBonus {

    PÉSSIMO(1, "Bonus Péssimo"),
    RUIM(2, "Bonus Ruim"),
    REGULAR(3, "Bonus Regular"),
    BOM(4, "Bonus Bom"),
    ÓTIMO(5, "Bonus Ótimo"),
    NORMAL(6, "Bonus Normal"),
    GENEROSO(7, "Bonus Generoso");

    private final double value;
    private final String description;

    TipoBonus(double value, String description) {
        this.value = value;
        this.description = description;
    }

    public static TipoBonus getPÉSSIMO() {
        return PÉSSIMO;
    }

    public static TipoBonus getRUIM() {
        return RUIM;
    }

    public static TipoBonus getREGULAR() {
        return REGULAR;
    }

    public static TipoBonus getBOM() {
        return BOM;
    }

    public static TipoBonus getÓTIMO() {
        return ÓTIMO;
    }

    public static TipoBonus getNORMAL() {
        return NORMAL;
    }

    public static TipoBonus getGENEROSO() {
        return GENEROSO;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static List<Double> getValues(List<TipoBonus> enumList) {
        var list = enumList.stream().map(x -> x.value).collect(Collectors.toList());
        return list;
    }

    public static List<String> getEnumListByValues(List<String> listValues) {
        var list = listValues.stream().map(x -> x).collect(Collectors.toList());
        return list;
    }
}
