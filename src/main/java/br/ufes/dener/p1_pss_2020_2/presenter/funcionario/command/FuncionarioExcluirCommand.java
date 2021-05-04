package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.collection.FuncionarioCollection;
import br.ufes.dener.p1_pss_2020_2.log.Logger;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewManterFuncionario;

public class FuncionarioExcluirCommand extends FuncionarioCommand {

    @Override
    public void executarExcluir(ViewManterFuncionario viewManterFuncionario) throws Exception {
        try {
            var nome = viewManterFuncionario.getjTextField2().getText().toString();
            var funcionario = FuncionarioCollection.getFuncionarioCollection().getFuncionarioByNome(nome);

            if (funcionario == null) {
                throw new Exception("ErroExcluir");
            } else {
                String tipo = "EXCLUIDO!";
                Logger.salvarLog(funcionario, tipo);
            }

            FuncionarioCollection.getFuncionarioCollection().removerFuncionario(funcionario.getNome());
        } catch (Exception ex) {
        }
    }
}
