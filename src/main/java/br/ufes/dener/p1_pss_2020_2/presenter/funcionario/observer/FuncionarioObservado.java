package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.observer;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import java.util.ArrayList;
import java.util.List;

public abstract class FuncionarioObservado {
    private List<IFuncionarioObserver> observers = new ArrayList<>();
    
    public void add(IFuncionarioObserver funcionarioObserver){
        this.observers.add(funcionarioObserver);
    }
    
    public void notifica(){
        for (var observer : this.observers) {
            observer.update(FuncionarioCollection.getFuncionarioCollection());
        }
    }
}
