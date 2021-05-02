package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewBuscarFuncionario;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewManterFuncionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioCommand {

    public static class ExecutarGetAll {

        public ExecutarGetAll(ViewBuscarFuncionario viewBuscarFuncionario) throws Exception {
            try {
                var funcionarios = FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios();

                ((DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel()).setNumRows(0);
                viewBuscarFuncionario.getjTable1().updateUI();
                DefaultTableModel model = (DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel();
                if (funcionarios == null) {
                    JOptionPane.showMessageDialog(null, "Sem Funcionarios Cadastrados!");
                } else {
                    for (Funcionario funcionario : funcionarios) {
                        model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCargo(), funcionario.getSalario()});
                        String tipo = "BUSCADO GET ALL!";
                        Logger.salvarLog(funcionario, tipo);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static class ExecutarInserir {

        public ExecutarInserir(ViewManterFuncionario viewManterFuncionario) {
            Funcionario funcionario = new Funcionario();

            getDados(viewManterFuncionario, funcionario);

            FuncionarioCollection.getFuncionarioCollection().adicionarFuncionario(funcionario);

            String tipo = "INSERIDO!";
            Logger.salvarLog(funcionario, tipo);

        }

        private Funcionario getDados(ViewManterFuncionario viewManterFuncionario, Funcionario funcionario) {

            var cargo = viewManterFuncionario.getjComboBox1().getSelectedItem().toString();
            var nome = viewManterFuncionario.getjTextField2().getText();
            var idade = viewManterFuncionario.getjTextField3().getText();
            var bonus = viewManterFuncionario.getjComboBox2().getSelectedItem().toString();
            var salario = viewManterFuncionario.getjTextField4().getText();
            var faltas = viewManterFuncionario.getjTextField5().getText();
            var funcionarioDoMes = viewManterFuncionario.getjCheckBox1().isSelected();
            var admissao = viewManterFuncionario.getjFormattedTextField1().getText();

            if (cargo != null) {
                funcionario.setCargo(cargo);
            }
            if (nome != null) {
                funcionario.setNome(nome);
            }
            if (idade != null) {
                funcionario.setIdade(Integer.parseInt(idade));
            }
            if (bonus != null) {
                funcionario.setBonus(bonus);
            }
            if (salario != null) {
                funcionario.setSalario(Double.parseDouble(salario));
            }
            if (faltas != null) {
                funcionario.setFaltas(Integer.parseInt(faltas));
            }
            if (funcionarioDoMes) {
                funcionario.setFuncionarioDoMes(funcionarioDoMes);
            }
            if (admissao != null) {
                funcionario.setAdmissao(LocalDate.parse(admissao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            return funcionario;
        }
    }

    public static class ExecutarEditar {

        public ExecutarEditar(ViewManterFuncionario viewManterFuncionario) {
            Funcionario funcionario = new Funcionario();

            this.getDados(viewManterFuncionario, funcionario);

            FuncionarioCollection.getFuncionarioCollection().atualizarFuncionario(funcionario.getId(), funcionario);

            String tipo = "EDITADO!";
            Logger.salvarLog(funcionario, tipo);
        }

        private Funcionario getDados(ViewManterFuncionario viewManterFuncionario, Funcionario funcionario) {

            var cargo = viewManterFuncionario.getjComboBox1().getSelectedItem().toString();
            var nome = viewManterFuncionario.getjTextField2().getText();
            var idade = viewManterFuncionario.getjTextField3().getText();
            var bonus = viewManterFuncionario.getjComboBox2().getSelectedItem().toString();
            var salario = viewManterFuncionario.getjTextField4().getText();
            var faltas = viewManterFuncionario.getjTextField5().getText();
            var funcionarioDoMes = viewManterFuncionario.getjCheckBox1().isSelected();
            var admissao = viewManterFuncionario.getjFormattedTextField1().getText();

            if (cargo != null) {
                funcionario.setCargo(cargo);
            }
            if (nome != null) {
                funcionario.setNome(nome);
            }
            if (idade != null) {
                funcionario.setIdade(Integer.parseInt(idade));
            }
            if (bonus != null) {
                funcionario.setBonus(bonus);
            }
            if (salario != null) {
                funcionario.setSalario(Double.parseDouble(salario));
            }
            if (faltas != null) {
                funcionario.setFaltas(Integer.parseInt(faltas));
            }
            if (funcionarioDoMes) {
                funcionario.setFuncionarioDoMes(funcionarioDoMes);
            }
            if (admissao != null) {
                funcionario.setAdmissao(LocalDate.parse(admissao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            return funcionario;
        }
    }

    public static class ExecutarExcluir {

        public ExecutarExcluir(ViewManterFuncionario viewManterFuncionario) {

            try {
                var nome = viewManterFuncionario.getjTextField2().getText().toString();
                var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioByNome(nome);

                String tipo = "DELETADO!";
                Logger.salvarLog(funcionario, tipo);
                FuncionarioCollection.getFuncionarioCollection().removerFuncionario(viewManterFuncionario.getjTextField2().getText().toString());

            } catch (Exception ex) {

            }
        }
    }

    public static class ExecutarGetByNome {

        public ExecutarGetByNome(ViewBuscarFuncionario viewBuscarFuncionario, String busca) throws Exception {
            ((DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel()).setNumRows(0);
            viewBuscarFuncionario.getjTable1().updateUI();

            DefaultTableModel model = (DefaultTableModel) viewBuscarFuncionario.getjTable1().getModel();

            if (FuncionarioCollection.getFuncionarioCollection().getAllFuncionarios() == null) {
                JOptionPane.showMessageDialog(null, "Sem funcionarios Cadastrados");
            } else {
                var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioByNome(busca);
                model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCargo(), funcionario.getSalario()});
                String tipo = "BUSCADO POR TEXTO!";
                Logger.salvarLog(funcionario, tipo);
            }
        }
    }
}
