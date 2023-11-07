package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDepositRemove implements ActionListener {
    private BebidasInterface bebida;
    private JFrame janelaprincipal;
    ImageIcon removeIcon = new ImageIcon("./src/main/resources/removeBebida.png");

    public ControllerDepositRemove(BebidasInterface bebida, JFrame janela){
        this.bebida= bebida;
        this.janelaprincipal= janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDaBebida = (String) JOptionPane.showInputDialog(janelaprincipal,"Qual o nome da Bebida", "Remoção do Estoque", JOptionPane.DEFAULT_OPTION, removeIcon, null, null);
        boolean removeu = bebida.removeBebidas(nomeDaBebida);
        if(removeu){
            JOptionPane.showMessageDialog(janelaprincipal,"Bebida removida com sucesso", "Remoção do Estoque", JOptionPane.DEFAULT_OPTION, removeIcon);
        }else{
            JOptionPane.showMessageDialog(janelaprincipal,"Bebida não foi encontrada." + " Operação não realizada", "Remoção do Estoque", JOptionPane.DEFAULT_OPTION, removeIcon);
        }
    }
}
