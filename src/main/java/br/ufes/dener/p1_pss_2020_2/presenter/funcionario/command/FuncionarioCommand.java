package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.command;

import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewBuscarFuncionario;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewManterFuncionario;

public abstract class FuncionarioCommand {

    public void executarInserir(ViewManterFuncionario viewManterFuncionario) throws Exception {
    }

    public void executarEditar(ViewManterFuncionario viewManterFuncionario) throws Exception {
    }

    public void executarGetAll(ViewBuscarFuncionario viewBuscarFuncionario) throws Exception {
    }

    public void executarExcluir(ViewManterFuncionario viewManterFuncionario) throws Exception {
    }

    public void executarGetByNome(ViewBuscarFuncionario viewBuscarFuncionario, String busca) throws Exception {
    }
}
