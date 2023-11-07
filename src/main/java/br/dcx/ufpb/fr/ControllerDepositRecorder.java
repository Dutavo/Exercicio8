package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class ControllerDepositRecorder implements ActionListener{

    private BebidasInterface bebida;
    private JFrame janelaPrincipal;

    public ControllerDepositRecorder( BebidasInterface bebida, JFrame janelaPrincipal) {
        this.bebida = bebida;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bebida.salvarAsBebidas();
        JOptionPane.showMessageDialog(janelaPrincipal, "Dados Sincronizados com Sucesso!", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
    }
}
