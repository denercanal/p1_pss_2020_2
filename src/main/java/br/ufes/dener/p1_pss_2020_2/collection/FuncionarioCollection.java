package br.ufes.dener.p1_pss_2020_2.collection;

import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import br.ufes.dener.p1_pss_2020_2.presenter.funcionario.observer.FuncionarioObservado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioCollection extends FuncionarioObservado {

    private ArrayList<Funcionario> funcionarios;
    private static FuncionarioCollection instaciaFuncionarioCollection;

    public FuncionarioCollection(ArrayList<Funcionario> funcionarios) {
        if (funcionarios != null) {
            this.funcionarios = funcionarios;
            notifica();
        }
    }

    private FuncionarioCollection() {
        this.funcionarios = new ArrayList<>();
        notifica();
    }

    public static FuncionarioCollection getFuncionarioCollection() {
        if (instaciaFuncionarioCollection == null) {
            return instaciaFuncionarioCollection = new FuncionarioCollection();
        } else {
            return instaciaFuncionarioCollection;
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionario.setId(funcionarios.size());
        this.funcionarios.add(funcionario);
        notifica();
    }

    public void removerFuncionario(String nome) throws Exception {
        if (getAllFuncionarios().size() != 0) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome() == null ? nome == null : funcionario.getNome().equals(nome)) {
                    this.funcionarios.remove(funcionario);
                    notifica();
                } else {
                    JOptionPane.showMessageDialog(null, "Não encontrado!");
                }
            }
        } else {

        }

    }

    public List<Funcionario> getAllFuncionarios() throws Exception {
        if (funcionarios.isEmpty()) {

        } else {
            return this.funcionarios;
        }
        return null;
    }

    public Funcionario getFuncionarioById(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void atualizarFuncionario(int id, Funcionario funcionario) {
        this.funcionarios.set(id, funcionario);
        notifica();
    }

    public Funcionario getFuncionarioByNome(String busca) throws Exception {
        try {
            if (funcionarios.isEmpty()) {
                throw new Exception("Sem funcionarios!");
            } else {
                for (Funcionario funcionario : funcionarios) {
                    if (funcionario.getNome().contains(busca)) {
                        return funcionario;
                    };
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Funcionario> getFuncionariosByData(LocalDate data) throws Exception {
        List<Funcionario> funcionariosPeriodoSelecionado = new ArrayList<>();

        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem funcionarios no período!");
        } else {
            for (Funcionario funcionario : funcionarios) {
                if (data.equals(funcionario.getAdmissao())) {
                    funcionariosPeriodoSelecionado.add(funcionario);
                }
            }
            return funcionariosPeriodoSelecionado;
        }
        return null;
    }

    public int getTotalFuncionarios() {
        return this.funcionarios.size();
    }

    public Funcionario getFuncionarioByBonus(String bonus) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getBonus() == bonus) {
                return funcionario;
            }
        }
        return null;
    }
}
