package br.ufes.dener.p1_pss_2020_2.presenter.funcionario;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command.FuncionarioGetAllCommand;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command.FuncionarioGetByNomeCommand;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.modal.VerBonusPresenter;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewBuscarFuncionario;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class BuscarFuncionarioPresenter {

    private ViewBuscarFuncionario viewBuscarFuncionario;
    private final ViewTelaPrincipal viewTelaPrincipal;

    public BuscarFuncionarioPresenter(ViewTelaPrincipal viewTelaPrincipal) {

        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewBuscarFuncionario = new ViewBuscarFuncionario();

        this.viewBuscarFuncionarioBuscar();
        this.viewBuscarFuncionarioFechar();
        this.viewBuscarFuncionarioVisualizar();
        this.viewBuscarFuncionarioVerBonus();
        this.viewBuscarFuncionarioNovo();
    }

    public void viewBuscarFuncionario(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal.getjDesktopPane1().add(this.viewBuscarFuncionario);
        this.viewBuscarFuncionario.setVisible(true);
    }

    public ViewBuscarFuncionario getViewBuscarFuncionario() {
        return viewBuscarFuncionario;
    }

    private void viewBuscarFuncionarioBuscar() {
        this.viewBuscarFuncionario.getjButton1().addActionListener((ActionEvent e) -> {
            System.out.println("buscar");
            if (this.viewBuscarFuncionario.getjTextField1().getText().isBlank()) {
                try {
                    new FuncionarioGetAllCommand().executarGetAll(this.getViewBuscarFuncionario());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this.getViewBuscarFuncionario(), ex.getMessage(), "ERRO!", JOptionPane.OK_OPTION);
                }
            } else {
                try {
                    var busca = this.viewBuscarFuncionario.getjTextField1().getText().toString();
                    new FuncionarioGetByNomeCommand().executarGetByNome(this.getViewBuscarFuncionario(), busca);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this.getViewBuscarFuncionario(), ex.getMessage(), "ERRO!", JOptionPane.OK_OPTION);
                }
            }

        });
    }

    private void viewBuscarFuncionarioFechar() {
        this.viewBuscarFuncionario.getjButton2().addActionListener((ActionEvent e) -> {
            System.out.println("fechar");
            this.viewBuscarFuncionario.dispose();
        });
    }

    private void viewBuscarFuncionarioVisualizar() {
        this.viewBuscarFuncionario.getjButton3().addActionListener((ActionEvent e) -> {
            System.out.println("visualizar");
            if (viewBuscarFuncionario.getjTable1().getRowCount() > 0) {

                try {
                    var linhaSelecionada = viewBuscarFuncionario.getjTable1().getSelectedRow();
                    var idFuncionario = viewBuscarFuncionario.getjTable1().getValueAt(linhaSelecionada, 0);
                    var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioById((int) idFuncionario);
                    ManterFuncionarioPresenter manterFuncionarioPresenter = new ManterFuncionarioPresenter(viewTelaPrincipal, funcionario);
                    manterFuncionarioPresenter.viewManterFuncionario();
                } catch (Exception ex) {

                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor cadastrar ou selecionar uma linha!");
            }

        });
    }

    private void viewBuscarFuncionarioVerBonus() {
        this.viewBuscarFuncionario.getjButton4().addActionListener((ActionEvent e) -> {
            System.out.println("Ver Bonus");
            if (viewBuscarFuncionario.getjTable1().getRowCount() <= 0) {
                JOptionPane.showMessageDialog(null, "Favor cadastrar ou selecionar uma linha!");
            } else {
                try {
                    var linhaSelecionada = viewBuscarFuncionario.getjTable1().getSelectedRow();
                    var idFuncionario = viewBuscarFuncionario.getjTable1().getValueAt(linhaSelecionada, 0);
                    var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioById((int) idFuncionario);
                    VerBonusPresenter verBonusPresenter = new VerBonusPresenter(new Frame(), true, funcionario);
                    verBonusPresenter.viewVerBonusModal();
                } catch (Exception ex) {

                }
            }

        });
    }

    private void viewBuscarFuncionarioNovo() {
        this.viewBuscarFuncionario.getjButton5().addActionListener((ActionEvent e) -> {
            System.out.println("Novo");
            try {
                ManterFuncionarioPresenter manterFuncionarioPresenter = new ManterFuncionarioPresenter(viewTelaPrincipal, null);
                manterFuncionarioPresenter.viewManterFuncionario();
            } catch (Exception ex) {

            }
        });
    }
}
