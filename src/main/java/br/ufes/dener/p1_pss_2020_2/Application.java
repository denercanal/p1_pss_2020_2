package br.ufes.dener.p1_pss_2020_2;

import br.ufes.dener.p1_pss_2020_2.presenter.telaprincipal.TelaPrincipalPresenter;
import br.ufes.dener.p1_pss_2020_2.view.telaprincipal.ViewTelaPrincipal;

public class Application {

    public static void main(String[] args) {

        //Aplicando Tema Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        System.out.println("Programa Iniciado!");
        TelaPrincipalPresenter telaPrincipal = new TelaPrincipalPresenter();
        telaPrincipal.viewTelaPrincipal();
    }
}
