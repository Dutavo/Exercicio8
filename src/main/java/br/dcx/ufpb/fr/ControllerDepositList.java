package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ControllerDepositList implements ActionListener {

    private BebidasInterface bebida;
    private JFrame janelaPrincipal;


    public ControllerDepositList(BebidasInterface bebida, JFrame janela) {
        this.bebida = bebida;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Collection<Bebidas> bebidas = bebida.listarBebidas();
        if (bebidas.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há nenhum dado registrado no sistema", "Estoque", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Estoque: \n" + bebidas, "Estoque", JOptionPane.INFORMATION_MESSAGE);
        }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String nomeDaBebida = (String) JOptionPane.showInputDialog(janelaPrincipal, "Informe o nome da bebida", "Verificar Quantidade Estoque", JOptionPane.DEFAULT_OPTION);
//        int verificar = bebida.verificarQuantBebidas(nomeDaBebida);
//        JOptionPane.showMessageDialog(janelaPrincipal, "Verificar Quantidade em Estoque: " + this.bebida.verificarQuantBebidas(nomeDaBebida), "Verificação", JOptionPane.INFORMATION_MESSAGE);
//    }
    }
}

