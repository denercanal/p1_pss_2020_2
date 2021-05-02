package br.ufes.dener.p1_pss_2020_2.presenter.funcionario;

import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state.FuncionarioEstados;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state.FuncionarioInserirState;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.state.FuncionarioVisualizarState;
import br.ufes.dener.p1_pss_2020_2.view.funcionario.ViewManterFuncionario;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;

public class ManterFuncionarioPresenter {

    private FuncionarioEstados estado;
    private ViewManterFuncionario viewManterFuncionario;
    private final ViewTelaPrincipal viewTelaPrincipal;
    private Funcionario funcionario;

    public ManterFuncionarioPresenter(ViewTelaPrincipal viewTelaPrincipal, Funcionario funcionario) throws Exception {

        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewManterFuncionario = new ViewManterFuncionario();

        if (funcionario == null) {
            this.estado = new FuncionarioInserirState(this);
        } else {
            this.funcionario = funcionario;
            this.estado = new FuncionarioVisualizarState(this);
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioEstados getEstado() {
        return estado;
    }

    public void setEstado(FuncionarioEstados estado) {
        this.estado = estado;
    }

    public void viewManterFuncionario() {
        viewTelaPrincipal.getjDesktopPane1().add(this.viewManterFuncionario);
        this.viewManterFuncionario.setVisible(true);
    }

    public ViewManterFuncionario getViewManterFuncionario() {
        return viewManterFuncionario;
    }

    public void inserir() {
        estado.inserir();
    }

    public void editar() {
        estado.editar();
    }

    public void visualizar() {
        estado.visualizar();
    }

    public void removerListeners() {
        if (getViewManterFuncionario().getjButton3().getActionListeners() != null) {
            var inserir = getViewManterFuncionario().getjButton3().getActionListeners();
            for (var actionListener : inserir) {
                getViewManterFuncionario().getjButton3().removeActionListener(actionListener);
            }
        }

        if (getViewManterFuncionario().getjButton4().getActionListeners() != null) {
            var editar = getViewManterFuncionario().getjButton4().getActionListeners();
            for (var actionListener : editar) {
                getViewManterFuncionario().getjButton3().removeActionListener(actionListener);
            }
        }

        if (getViewManterFuncionario().getjButton2().getActionListeners() != null) {
            var inserir = getViewManterFuncionario().getjButton2().getActionListeners();
            for (var actionListener : inserir) {
                getViewManterFuncionario().getjButton2().removeActionListener(actionListener);
            }
        }

        if (getViewManterFuncionario().getjButton5().getActionListeners() != null) {
            var fechar = getViewManterFuncionario().getjButton5().getActionListeners();
            for (var actionListener : fechar) {
                getViewManterFuncionario().getjButton5().removeActionListener(actionListener);
            }
        }
    }
}
