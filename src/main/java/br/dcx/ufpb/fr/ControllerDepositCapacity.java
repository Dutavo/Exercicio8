package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDepositCapacity implements ActionListener {

    private BebidasInterface bebida;
    private JFrame janelaPrincipal;


    public ControllerDepositCapacity(BebidasInterface bebida, JFrame janela){
        this.bebida= bebida;
        this.janelaPrincipal= janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JOptionPane.showMessageDialog(janelaPrincipal, "Capacidade Total em Estoque: " + this.bebida.capacidadeDoEstoque() + "/500", "Capacidade", JOptionPane.INFORMATION_MESSAGE);
        } catch (ExceptionCapacidadeCheia ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Capacidade do Estoque Cheia Patrão! ", "Capacidade Em Estoque", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}
