package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.*;

public class LogoEntrace extends JOptionPane {

    public static int showMensage(){
        LogoEntrace optionPane = new LogoEntrace();
        JPanel painel = new JPanel(new BorderLayout());
        ImageIcon iconLW = new ImageIcon("./src/main/resources/logoWhite.png");
        JLabel iconLabel = new JLabel(iconLW);
        painel.add(iconLabel, BorderLayout.CENTER);
        Object[] options = { "ENTRAR"};
        int mensagem = JOptionPane.showOptionDialog(null, painel, "Bem Vindo ao Emporio Lcc - Deposito de Bebidas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return mensagem;
    }
}
