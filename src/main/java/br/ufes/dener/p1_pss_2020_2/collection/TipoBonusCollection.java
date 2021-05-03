package br.ufes.dener.p1_pss_2020_2.collection;

import br.ufes.dener.p1_pss_2020_2.model.TipoBonus;
import java.util.ArrayList;
import java.util.List;

public class TipoBonusCollection {

    private ArrayList<TipoBonus> listaBonus;
    private static TipoBonusCollection instaciaTipoBonusCollection;

    public TipoBonusCollection(ArrayList<TipoBonus> listaBonus) {

        if (listaBonus != null) {
            this.listaBonus = listaBonus;
        }

    }

    private TipoBonusCollection() {
        this.listaBonus = new ArrayList<>();
    }

    public static TipoBonusCollection getTipoBonusCollection() {
        if (instaciaTipoBonusCollection == null) {
            return instaciaTipoBonusCollection = new TipoBonusCollection();
        } else {
            return instaciaTipoBonusCollection;
        }
    }

    public void inserirBonus(TipoBonus bonus) {
        listaBonus.add(bonus);
    }

    public List<TipoBonus> getAllBonus() {
        List<TipoBonus> listaDeBonus = new ArrayList<>();
        for (TipoBonus bonus : listaBonus) {
            listaDeBonus.add(bonus);
        }
        return listaDeBonus;
    }

    public void inserirBonus(int i, String bonus) {
        if (bonus.equalsIgnoreCase(TipoBonus.NORMAL.getDescription())) {
            listaBonus.add(i, TipoBonus.NORMAL);
        } else if (bonus.equalsIgnoreCase(TipoBonus.GENEROSO.getDescription())) {
            listaBonus.add(TipoBonus.GENEROSO);
        }
    }

//    public List<TipoBonus> getBonusByFuncionario(Funcionario funcionario) {
//        var bonusFuncionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioByBonus(funcionario.getBonus());
//        List<TipoBonus> listaTipoBonus = new ArrayList<>();
//        for (TipoBonus bonus : listaBonus) {
//            if (bonusFuncionario.getBonus().equalsIgnoreCase(TipoBonus.GENEROSO.getDescription()) || bonusFuncionario.getBonus().equalsIgnoreCase(TipoBonus.GENEROSO.getDescription())) {
//                listaTipoBonus.add(bonus);
//            }
//            return listaTipoBonus;
//        }
//        return null;
//
//    }

}
