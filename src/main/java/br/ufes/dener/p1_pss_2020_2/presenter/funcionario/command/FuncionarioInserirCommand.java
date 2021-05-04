package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.collection.TipoBonusCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.model.TipoBonus;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewManterFuncionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FuncionarioInserirCommand extends FuncionarioCommand {

    @Override
    public void executarInserir(ViewManterFuncionario viewManterFuncionario) throws Exception {

        try {
            Funcionario funcionario = new Funcionario();

            this.validaCampos(viewManterFuncionario);
            funcionario = this.getDados(viewManterFuncionario, funcionario);

            FuncionarioCollection.getFuncionarioCollection().adicionarFuncionario(funcionario);

            if (funcionario.getBonus().equalsIgnoreCase(TipoBonus.NORMAL.toString())) {
                TipoBonusCollection.getTipoBonusCollection().inserirBonus(funcionario.getId(), funcionario.getBonus());
            } else if (funcionario.getBonus().equalsIgnoreCase(TipoBonus.GENEROSO.toString())) {
                TipoBonusCollection.getTipoBonusCollection().inserirBonus(funcionario.getId(), funcionario.getBonus());
            }

            if (funcionario == null) {
                Logger.salvarLog(null, "ErroInserir");
            } else {
                String tipo = "INSERIDO!";
                Logger.salvarLog(funcionario, tipo);
            }
        } catch (Exception e) {
            throw e;
        }

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
        if (TipoBonus.GENEROSO.getDescription().equalsIgnoreCase(bonus)) {
            funcionario.setValorBonus(32);
        }
        if (TipoBonus.NORMAL.getDescription().equalsIgnoreCase(bonus)) {
            funcionario.setValorBonus(8);
        }
        return funcionario;
    }

    private void validaCampos(ViewManterFuncionario viewManterFuncionario) throws Exception {

        if (viewManterFuncionario.getjComboBox1().getSelectedItem() == null) {
            throw new Exception("Favor selecionar um cargo");
        }

        if (viewManterFuncionario.getjTextField2().getText().isBlank()) {
            throw new Exception("Favor digitar um nome");
        }

        if (viewManterFuncionario.getjTextField3().getText().isBlank()) {
            throw new Exception("Favor digitar uma idade");
        }

        if (viewManterFuncionario.getjComboBox2().getSelectedItem() == null) {
            throw new Exception("Favor selecionar um bonus");
        }

        if (viewManterFuncionario.getjTextField4().getText().isBlank()) {
            throw new Exception("Favor digitar um salario");
        }

        if (viewManterFuncionario.getjTextField5().getText().isBlank()) {
            throw new Exception("Favor digitar faltas");
        }

        if (viewManterFuncionario.getjFormattedTextField1().getText().isBlank() || viewManterFuncionario.getjFormattedTextField1().getText().equals("  /  /    ")) {
            throw new Exception("Favor digitar uma data");
        }
    }
}
