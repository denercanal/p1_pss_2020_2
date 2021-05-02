package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.observer;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;

public interface IFuncionarioObserver {

    public void update(FuncionarioCollection funcionarioCollection);
}
