package br.ufes.dener.p1_pss_2020_2.presenter.salario;

import br.ufes.dener.p1_pss_2020_2.view.salario.ViewCalcularSalario;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;
import java.awt.event.ActionEvent;

public class CalcularSalarioPresenter {

    private final ViewCalcularSalario calcularSalario;
    private final ViewTelaPrincipal telaPrincipal;

    public CalcularSalarioPresenter(ViewTelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.calcularSalario = new ViewCalcularSalario();
        
        this.viewCalcularSalarioBuscar();
        this.viewCalcularSalarioListarTodos();
        this.viewCalcularSalarioFechar();
        this.viewCalcularSalarioCalcular();
    }

    public void viewCalcularSalario() {
        this.telaPrincipal.getjDesktopPane1().add(this.calcularSalario);
        this.calcularSalario.setVisible(true);
    }

    private void viewCalcularSalarioBuscar() {
        this.calcularSalario.getjButton1().addActionListener((ActionEvent arg0) -> {
            System.out.println("Buscar");
            this.calcularSalario.dispose();
        });
    }

    private void viewCalcularSalarioListarTodos() {
        this.calcularSalario.getjButton2().addActionListener((ActionEvent arg0) -> {
            System.out.println("Listar Todos");
            this.calcularSalario.dispose();
        });
    }

    private void viewCalcularSalarioFechar() {
        this.calcularSalario.getjButton3().addActionListener((ActionEvent arg0) -> {
            System.out.println("Fechar");
            this.calcularSalario.dispose();
        });
    }

    private void viewCalcularSalarioCalcular() {
        this.calcularSalario.getjButton4().addActionListener((ActionEvent arg0) -> {
            System.out.println("Calcular");
            this.calcularSalario.dispose();
        });
    }
}
