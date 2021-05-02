package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state;

import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.ManterFuncionarioPresenter;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command.FuncionarioCommand;
import java.awt.event.ActionEvent;

public class FuncionarioEditarState extends FuncionarioEstados {

    private ManterFuncionarioPresenter manterFuncionarioPresenter;

    public FuncionarioEditarState(ManterFuncionarioPresenter manterFuncionarioPresenter) {
        super(manterFuncionarioPresenter);
        this.manterFuncionarioPresenter = manterFuncionarioPresenter;

        this.manterFuncionarioPresenter.removerListeners();

        this.viewManterFuncionarioOptions();
        this.viewManterFuncionarioEditar();
        this.viewManterFuncionarioFechar();
    }

    @Override
    public void editar() {
        new FuncionarioCommand.ExecutarEditar(this.manterFuncionarioPresenter.getViewManterFuncionario());
        try {
            manterFuncionarioPresenter.setEstado(new FuncionarioVisualizarState(this.manterFuncionarioPresenter));
            this.manterFuncionarioPresenter.getViewManterFuncionario().dispose();
        } catch (Exception ex) {
        }
    }

    @Override
    public void fechar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().dispose();
    }

    private void viewManterFuncionarioOptions() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField2().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField3().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField4().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField5().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox1().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox2().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjCheckBox1().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjFormattedTextField1().setEnabled(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton3().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton4().setVisible(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton5().setVisible(false);
    }

    private void viewManterFuncionarioFechar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton2().addActionListener((ActionEvent e) -> {
            System.out.println("Fechar");
            this.fechar();
        });
    }

    private void viewManterFuncionarioEditar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton4().addActionListener((ActionEvent e) -> {
            System.out.println("Editar");
            this.editar();
        });
    }
}
