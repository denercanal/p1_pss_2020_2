package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state;

import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.ManterFuncionarioPresenter;

public abstract class FuncionarioEstados {

    private ManterFuncionarioPresenter manterFuncionarioPresenter;

    public FuncionarioEstados(ManterFuncionarioPresenter manterFuncionarioPresenter) {
        this.manterFuncionarioPresenter = manterFuncionarioPresenter;
    }

    public void inserir() {
    }

    public void editar() {
    }

    public void visualizar() {
    }

    public void excluir() {
    }

    public void fechar() {
    }
}
