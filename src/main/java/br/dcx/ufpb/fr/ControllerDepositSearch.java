package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ControllerDepositSearch implements ActionListener {
    private BebidasInterface bebida;
    private JFrame janelaPrincipal;


    ImageIcon searchIcon = new ImageIcon("./src/main/resources/searchBebida.png");

    public ControllerDepositSearch(BebidasInterface bebida, JFrame janela){
        this.bebida=bebida;
        this.janelaPrincipal=janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDaBebida = (String) JOptionPane.showInputDialog(janelaPrincipal, "Informe o nome da bebida", "Procura em Estoque", JOptionPane.DEFAULT_OPTION, searchIcon, null, null);
        Collection<Bebidas> bebidas = bebida.pesquisaBebidas(nomeDaBebida);
        if(bebidas.size()>0){
            for(Bebidas b: bebidas){
                JOptionPane.showMessageDialog(janelaPrincipal,b.toString(),"Procura em Estoque", JOptionPane.DEFAULT_OPTION, searchIcon);
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Não foi encontrado nenhuma bebida.", "Procura em Estoque", JOptionPane.DEFAULT_OPTION, searchIcon);

        }

    }
}
