package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewBuscarFuncionario;
import javax.swing.table.DefaultTableModel;

public class FuncionarioGetByNomeCommand extends FuncionarioCommand {

    @Override
    public void executarGetByNome(ViewBuscarFuncionario viewBuscarFuncionario, String busca) throws Exception {
        try {
            ((DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel()).setNumRows(0);
            viewBuscarFuncionario.getjTable1().updateUI();

            DefaultTableModel model = (DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel();

            if (FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios() == null) {
                throw new Exception("Sem Nome de Funcionarios Cadastrados!");
            } else {
                var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioByNome(busca);
                model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCargo(), funcionario.getSalario()});
                if (funcionario == null) {
                    Logger.salvarLog(null, "ErroGetByNome");
                } else {
                    String tipo = "GETBYNOME!";
                    Logger.salvarLog(funcionario, tipo);
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
