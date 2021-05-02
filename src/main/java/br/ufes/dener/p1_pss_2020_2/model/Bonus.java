package br.ufes.dener.p1_pss_2020_2.model;

public class Bonus {

    private TipoBonus tipoBonus;

    public Bonus() {
    }

    public Bonus(TipoBonus tipoBonus) {
        this.tipoBonus = tipoBonus;
    }

    public TipoBonus getTipoBonus() {
        return tipoBonus;
    }

    public void setTipoBonus(TipoBonus tipoBonus) {
        this.tipoBonus = tipoBonus;
    }
    
    
}
