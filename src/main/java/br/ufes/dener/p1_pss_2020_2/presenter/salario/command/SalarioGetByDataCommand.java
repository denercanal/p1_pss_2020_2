package br.ufes.dener.p1_pss_2020_2.presenter.salario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

public class SalarioGetByDataCommand extends SalarioCommand {

    @Override
    public void executarGetByData(ViewCalcularSalario viewCalcularSalario, LocalDate data) throws Exception {
        try {

            ((DefaultTableModel) viewCalcularSalario.getjTable1().getModel()).setNumRows(0);
            viewCalcularSalario.getjTable1().updateUI();

            var funcionarios = FuncionarioCollection.getFuncionarioCollection().getFuncionariosByData(data);

            DefaultTableModel model = (DefaultTableModel) viewCalcularSalario.getjTable1().getModel();

            if ((funcionarios.isEmpty())) {
                throw new Exception("Sem funcionários para essa data!");
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
                        Logger.salvarLog(null, "GetByDATA");
                    } else {
                        String tipo = "GETBYDATA!";
                        Logger.salvarLog(funcionario, tipo);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
