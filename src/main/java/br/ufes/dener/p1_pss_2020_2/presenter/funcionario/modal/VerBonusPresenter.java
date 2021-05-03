package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.modal;

import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.modal.ViewVerBonusModal;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerBonusPresenter {

    private final ViewVerBonusModal viewVerBonusModal;
    private Funcionario funcionario;

    public VerBonusPresenter(Frame parent, boolean modal, Funcionario funcionario) {
        this.viewVerBonusModal = new ViewVerBonusModal(parent, true);
        this.funcionario = funcionario;
        this.viewVerBonusModalOptions();
    }

    public void viewVerBonusModal() {
        this.viewVerBonusModal.setVisible(true);
    }

    private void viewVerBonusModalOptions() {

        //var listaBonus = new ArrayList<TipoBonus>();
        this.viewVerBonusModal.getjLabel3().setText(funcionario.getCargo());
        this.viewVerBonusModal.getjLabel4().setText(funcionario.getNome());

        ((DefaultTableModel) viewVerBonusModal.getjTable1().getModel()).setNumRows(0);
        viewVerBonusModal.getjTable1().updateUI();
        DefaultTableModel model = (DefaultTableModel) viewVerBonusModal.getjTable1().getModel();

        if (funcionario.getBonus() == null) {
            Logger.salvarLog(null, "ErroGetALL");
            JOptionPane.showMessageDialog(null, "Sem Funcionarios Cadastrados!");
        } else {
            model.addRow(new Object[]{funcionario.getBonus(), String.valueOf(funcionario.getValorBonus()), String.valueOf(funcionario.getDataBonus())});

            if (funcionario == null) {
                Logger.salvarLog(null, "ErroGetAll");
            } else {
                String tipo = "GETALL!";
                Logger.salvarLog(funcionario, tipo);
            }
        }
    }

//        var listaTipoBonus = TipoBonusCollection.getTipoBonusCollection().getBonusByFuncionario(funcionario);
//        
//        ((DefaultTableModel) viewVerBonusModal.getjTable1().getModel()).setNumRows(0);
//        viewVerBonusModal.getjTable1().updateUI();
//        DefaultTableModel model = (DefaultTableModel) viewVerBonusModal.getjTable1().getModel();
//
//        if (listaTipoBonus == null) {
//            Logger.salvarLog(null, "ErroGetALL");
//            JOptionPane.showMessageDialog(null, "Sem Funcionarios Cadastrados!");
//        } else {
//            for (TipoBonus tipoBonus : listaTipoBonus) {
//                model.addRow(new Object[]{tipoBonus.getDescription(), tipoBonus.getValue(), tipoBonus.getData()});
//                if (funcionario == null) {
//                    Logger.salvarLog(null, "ErroGetAll");
//                } else {
//                    String tipo = "GETALL!";
//                    Logger.salvarLog(funcionario, tipo);
//                }
//            }
//        }
}
