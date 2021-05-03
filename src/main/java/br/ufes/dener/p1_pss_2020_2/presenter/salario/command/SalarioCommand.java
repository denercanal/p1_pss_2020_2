package br.ufes.dener.p1_pss_2020_2.presenter.salario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalarioCommand {

    public static class ExecutarGetByData {

        public ExecutarGetByData(ViewCalcularSalario viewCalcularSalario, LocalDate data) throws Exception {
            ((DefaultTableModel) viewCalcularSalario.getjTable1().getModel()).setNumRows(0);
            viewCalcularSalario.getjTable1().updateUI();

            DefaultTableModel model = (DefaultTableModel) viewCalcularSalario.getjTable1().getModel();

            if (FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios() == null) {
                JOptionPane.showMessageDialog(null, "Sem funcionarios Cadastrados");
            } else {
                var funcionarios = FuncionarioCollection.getFuncionarioCollection().getFuncionariosByData(data);

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
        }
    }

    public static class ExecutarGetAll {

        public ExecutarGetAll(ViewCalcularSalario viewCalcularSalario) throws Exception {
            try {
                var funcionarios = FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios();

                ((DefaultTableModel) viewCalcularSalario.getjTable1().getModel()).setNumRows(0);
                viewCalcularSalario.getjTable1().updateUI();
                DefaultTableModel model = (DefaultTableModel) viewCalcularSalario.getjTable1().getModel();
                if (funcionarios == null) {
                    Logger.salvarLog(null, "ErroGetALL");
                    JOptionPane.showMessageDialog(null, "Sem Funcionarios Cadastrados!");
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
            }
        }
    }
}
