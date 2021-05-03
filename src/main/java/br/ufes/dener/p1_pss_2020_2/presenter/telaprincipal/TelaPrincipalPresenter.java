package br.ufes.dener.p1_pss_2020_2.presenter.telaprincipal;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.BuscarFuncionarioPresenter;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.observer.IFuncionarioObserver;
import br.ufes.dener.p1_pss_2020_2.presenter.salario.CalcularSalarioPresenter;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;
import java.awt.event.ActionEvent;

public class TelaPrincipalPresenter implements IFuncionarioObserver {

    private final ViewTelaPrincipal viewTelaPrincipal;

    public TelaPrincipalPresenter() {

        this.viewTelaPrincipal = new ViewTelaPrincipal();
        this.viewBuscarFuncionario();
        this.viewCalcularSalario();
        FuncionarioCollection.getFuncionarioCollection().add(this);
    }

    public void viewTelaPrincipal() {
        this.viewTelaPrincipal.setVisible(true);
    }
    
    public ViewTelaPrincipal getViewTelaPrincipal() {
        return this.viewTelaPrincipal;
    }

    private void viewBuscarFuncionario() {
        viewTelaPrincipal.getjMenuItem1().addActionListener((ActionEvent arg0) -> {
            BuscarFuncionarioPresenter buscarFuncionarioPresenter = new BuscarFuncionarioPresenter(viewTelaPrincipal);
            buscarFuncionarioPresenter.viewBuscarFuncionario(viewTelaPrincipal);
        });
    }

    private void viewCalcularSalario() {
        viewTelaPrincipal.getjMenuItem2().addActionListener((ActionEvent arg0) -> {
            CalcularSalarioPresenter calcularSalarioPresenter = new CalcularSalarioPresenter(viewTelaPrincipal);
            calcularSalarioPresenter.viewCalcularSalario();
        });
    }

    @Override
    public void update(FuncionarioCollection funcionarioCollection) {
        var totalFuncionarios = funcionarioCollection.getTotalFuncionarios();
        this.viewTelaPrincipal.getjLabel4().setText(String.valueOf(totalFuncionarios));
    }
}
