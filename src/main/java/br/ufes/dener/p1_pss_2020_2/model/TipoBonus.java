package br.ufes.dener.p1_pss_2020_2.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public enum TipoBonus {

    PESSIMO(0, "Bonus Péssimo", LocalDate.now()),
    RUIM(1, "Bonus Ruim", LocalDate.now()),
    REGULAR(2, "Bonus Regular", LocalDate.now()),
    BOM(4, "Bonus Bom", LocalDate.now()),
    NORMAL(8, "Bonus Normal", LocalDate.now()),
    OTIMO(16, "Bonus Ótimo", LocalDate.now()),
    GENEROSO(32, "Bonus Generoso", LocalDate.now());

    private final double value;
    private final String description;
    private final LocalDate data;

    TipoBonus(double value, String description, LocalDate data) {
        this.value = value;
        this.description = description;
        this.data = data;
    }

    public static TipoBonus getPESSIMO() {
        return PESSIMO;
    }

    public static TipoBonus getOTIMO() {
        return OTIMO;
    }

    public LocalDate getData() {
        return data;
    }

    public static TipoBonus getPÉSSIMO() {
        return PESSIMO;
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
        return OTIMO;
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
