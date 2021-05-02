package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state;

import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.ManterFuncionarioPresenter;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command.FuncionarioCommand;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;

public class FuncionarioVisualizarState extends FuncionarioEstados {

    private ManterFuncionarioPresenter manterFuncionarioPresenter;

    public FuncionarioVisualizarState(ManterFuncionarioPresenter manterFuncionarioPresenter) throws Exception {
        super(manterFuncionarioPresenter);

        this.manterFuncionarioPresenter = manterFuncionarioPresenter;
        this.manterFuncionarioPresenter.removerListeners();
        
        this.viewManterFuncionarioOptions();
        this.viewManterFuncionarioVisualizar();
        this.viewManterFuncionarioFechar();
        this.viewManterFuncionarioEditar();
        this.viewManterFuncionarioExcluir();
    }

    @Override
    public void editar() {
        manterFuncionarioPresenter.setEstado(new FuncionarioEditarState(this.manterFuncionarioPresenter));
    }

    @Override
    public void excluir() {
        new FuncionarioCommand.ExecutarExcluir(this.manterFuncionarioPresenter.getViewManterFuncionario());
        this.manterFuncionarioPresenter.getViewManterFuncionario().dispose();
    }

    @Override
    public void fechar() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().dispose();
    }

    private void viewManterFuncionarioVisualizar() throws Exception {

        try {
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField2().setText(this.manterFuncionarioPresenter.getFuncionario().getNome());
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField3().setText(String.valueOf(this.manterFuncionarioPresenter.getFuncionario().getIdade()));
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField4().setText(String.valueOf(this.manterFuncionarioPresenter.getFuncionario().getSalario()));
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField5().setText(String.valueOf(this.manterFuncionarioPresenter.getFuncionario().getFaltas()));
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox1().setSelectedItem(this.manterFuncionarioPresenter.getFuncionario().getCargo());
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox2().setSelectedItem(this.manterFuncionarioPresenter.getFuncionario().getBonus());
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjFormattedTextField1().setText(this.manterFuncionarioPresenter.getFuncionario().getAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.manterFuncionarioPresenter.getViewManterFuncionario().getjCheckBox1().setSelected(this.manterFuncionarioPresenter.getFuncionario().getFuncionarioDoMes());
        } catch (Exception e) {

        }
    }

    private void viewManterFuncionarioOptions() {

        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField2().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField3().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField4().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjTextField5().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox1().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjComboBox2().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjFormattedTextField1().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjCheckBox1().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton3().setEnabled(false);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton4().setVisible(true);
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton5().setVisible(true);
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

    private void viewManterFuncionarioExcluir() {
        this.manterFuncionarioPresenter.getViewManterFuncionario().getjButton5().addActionListener((ActionEvent e) -> {
            System.out.println("Excluir");
            this.excluir();
        });
    }
}
