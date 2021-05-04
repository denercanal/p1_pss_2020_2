package br.ufes.dener.p1_pss_2020_2.presenter.salario.command;

import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import java.time.LocalDate;

public abstract class SalarioCommand {

    public void executarGetByData(ViewCalcularSalario viewCalcularSalario, LocalDate data) throws Exception {
    }

    public void executarGetAll(ViewCalcularSalario viewCalcularSalario) throws Exception {
    }
}
