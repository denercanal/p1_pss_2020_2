package br.ufes.dener.p1_pss_2020_2.presenter.salario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

public class SalarioGetAllCommand extends SalarioCommand {

    @Override
    public void executarGetAll(ViewCalcularSalario viewCalcularSalario) throws Exception {
        try {
            var funcionarios = FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios();

            ((DefaultTableModel) viewCalcularSalario.getjTable1().getModel()).setNumRows(0);
            viewCalcularSalario.getjTable1().updateUI();
            DefaultTableModel model = (DefaultTableModel) viewCalcularSalario.getjTable1().getModel();
            
            if (funcionarios == null) {
                Logger.salvarLog(null, "ErroGetALL");
                throw new Exception("Sem funcionários cadastrados!");
            } else {
                for (Funcionario funcionario : funcionarios) {
                    var x = funcionario.getBonus();

                    if (x.equalsIgnoreCase("generoso")) {
                        funcionario.setSalarioFinal(funcionario.getSalario() + (funcionario.getSalario() * 0.2));
                    } else {
                        funcionario.setSalarioFinal(funcionario.getSalario() + (funcionario.getSalario() * 0.1));
                    }
                    model.addRow(new Object[]{funcionario.getNome().toString(), funcionario.getAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), funcionario.getSalario(), "[ " + x + " ]", funcionario.getSalarioFinal()});
                    if (funcionario == null) {
                        Logger.salvarLog(null, "ErroGetAll");
                    } else {
                        String tipo = "GETALL!";
                        Logger.salvarLog(funcionario, tipo);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
