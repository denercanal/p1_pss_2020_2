package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state;

import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.ManterFuncionarioPresenter;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command.FuncionarioInserirCommand;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class FuncionarioInserirState extends FuncionarioEstados {

    private ManterFuncionarioPresenter manterFuncionarioPresenter;

    public FuncionarioInserirState(ManterFuncionarioPresenter manterFuncionarioPresenter) {
        super(manterFuncionarioPresenter);

        this.manterFuncionarioPresenter = manterFuncionarioPresenter;

        this.manterFuncionarioPresenter.removerListeners();
        this.viewManterFuncionarioOptions();
        this.viewManterFuncionarioLimpar();
        this.viewManterFuncionarioInserir();
        this.viewManterFuncionarioFechar();
    }

    @Override
    public void inserir() {
        try {
            new FuncionarioInserirCommand().executarInserir(this.manterFuncionarioPresenter.getViewManterFuncionario());
            this.manterFuncionarioPresenter.setEstado(new FuncionarioVisualizarState(this.manterFuncionarioPresenter));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.manterFuncionarioPresenter.getViewManterFuncionario(), ex.getMessage(), "ERRO!", JOptionPane.OK_OPTION);
        }

    }

    @Override
    public void fechar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().dispose();
    }

    private void viewManterFuncionarioLimpar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField2().setText("");
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField3().setText("");
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField4().setText("");
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField5().setText("");
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox1().setSelectedItem(null);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox2().setSelectedItem(null);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjFormattedTextField1().setText(null);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjCheckBox1().setSelected(false);
    }

    private void viewManterFuncionarioOptions() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton4().setVisible(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton5().setVisible(false);
    }

    private void viewManterFuncionarioFechar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton2().addActionListener((ActionEvent e) -> {
            System.out.println("Fechar");
            this.fechar();
        });
    }

    private void viewManterFuncionarioInserir() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton3().addActionListener((ActionEvent e) -> {
            this.inserir();
        });
    }
}
