package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDepositAboutUs implements ActionListener {
    private BebidasInterface bebida;
    private JFrame janelaPrincipal;


    public ControllerDepositAboutUs(BebidasInterface bebida, JFrame janela) {
        this.bebida = bebida;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(janelaPrincipal, "Emporio Lcc - Deposito de Bebidas    \n"  + "\nFundadores: \n•Fernanda Rodrigues da Silva" +
                "\n•Luiz Gustavo dos Santos Silva\n•Sara Nepomuceno do Nascimento     \n" + "\nSomos um deposito ao qual foi criado com o incentivo  de        \ncomercializar e armazenar bebidas " +
                "em grande escala,      \nalém da comercialização direta ao cliente, e distribuição à \nestabelecimentos de bebidas. \n", "Quem Somos?", JOptionPane.PLAIN_MESSAGE);
    }
}
