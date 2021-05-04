package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewBuscarFuncionario;
import javax.swing.table.DefaultTableModel;

public class FuncionarioGetAllCommand extends FuncionarioCommand{

    @Override
    public void executarGetAll(ViewBuscarFuncionario viewBuscarFuncionario) throws Exception {
        try {
            var funcionarios = FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios();

            ((DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel()).setNumRows(0);
            viewBuscarFuncionario.getjTable1().updateUI();
            DefaultTableModel model = (DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel();
            if (funcionarios == null) {
                Logger.salvarLog(null, "ErroGetALL");
            } else {
                for (Funcionario funcionario : funcionarios) {
                    model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCargo(), funcionario.getSalario()});
                    if (funcionario == null) {
                        Logger.salvarLog(null, "ErroGetAll");
                    } else {
                        String tipo = "GETALL!";
                        Logger.salvarLog(funcionario, tipo);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Sem Funcionarios Cadastrados!");
        }
    }
}
