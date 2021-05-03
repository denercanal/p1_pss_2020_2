package br.ufes.dener.p1_pss_2020_2.presenter.salario;

import br.ufes.dener.p1_pss_2020_2.presenter.salario.command.SalarioCommand;
import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalcularSalarioPresenter {

    private final ViewCalcularSalario viewCalcularSalario;
    private final ViewTelaPrincipal viewTelaPrincipal;

    public CalcularSalarioPresenter(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewCalcularSalario = new ViewCalcularSalario();

        this.viewCalcularSalarioBuscar();
        this.viewCalcularSalarioListarTodos();
        this.viewCalcularSalarioFechar();
        this.viewCalcularSalarioCalcular();
    }

    public void viewCalcularSalario() {
        this.viewTelaPrincipal.getjDesktopPane1().add(this.viewCalcularSalario);
        this.viewCalcularSalario.setVisible(true);
    }

    public ViewCalcularSalario getViewCalcularSalario() {
        return this.viewCalcularSalario;
    }

    private void viewCalcularSalarioBuscar() {
        this.viewCalcularSalario.getjButton1().addActionListener((ActionEvent arg0) -> {
            System.out.println("Buscar");
            var data = this.viewCalcularSalario.getjFormattedTextField1().getText();
            try {
                new SalarioCommand.ExecutarGetByData(this.viewCalcularSalario, LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } catch (Exception ex) {
            }
        });
    }

    private void viewCalcularSalarioListarTodos() {
        this.viewCalcularSalario.getjButton2().addActionListener((ActionEvent arg0) -> {
            System.out.println("Listar Todos");
            try {
                new SalarioCommand.ExecutarGetAll(this.viewCalcularSalario);
            } catch (Exception ex) {
                Logger.getLogger(CalcularSalarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void viewCalcularSalarioFechar() {
        this.viewCalcularSalario.getjButton3().addActionListener((ActionEvent arg0) -> {
            System.out.println("Fechar");
            this.viewCalcularSalario.dispose();
        });
    }

    private void viewCalcularSalarioCalcular() {
        this.viewCalcularSalario.getjButton4().addActionListener((ActionEvent arg0) -> {
            System.out.println("Calcular");

        });
    }
}
