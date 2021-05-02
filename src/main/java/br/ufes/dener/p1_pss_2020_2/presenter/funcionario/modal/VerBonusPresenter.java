package br.ufes.dener.p1_pss_2020_2.presenter.funcionario.modal;

import br.ufes.dener.p1_pss_2020_2.view.funcionario.modal.VerBonusModal;
import java.awt.Frame;

public class VerBonusPresenter {

    private final VerBonusModal verBonus;

    public VerBonusPresenter(Frame parent, boolean modal) {
        this.verBonus = new VerBonusModal(parent, true);
    }

    public void viewVerBonusModal() {
        this.verBonus.setVisible(true);
    }
}
