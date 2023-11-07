package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDepositAdd implements ActionListener {
    private BebidasInterface bebida;
    private JFrame janelaPrincipal;
    ImageIcon addIcon = new ImageIcon("./src/main/resources/addBebida.png");


    public ControllerDepositAdd(BebidasInterface bebida, JFrame janela){
        this.bebida= bebida;
        this.janelaPrincipal= janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDaBebida = (String) JOptionPane.showInputDialog(janelaPrincipal,"Qual o nome da Bebida?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null);
        int precoDaBebida = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o preço da Bebida?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null));
        int quantBebidas = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal,
                "Quantas Bebidas serão adicionadas?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null));
        
        try {
            boolean cadastrou = bebida.cadastraBebidas(nomeDaBebida, precoDaBebida, quantBebidas);
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Bebida Cadastrada!","cadastramento", JOptionPane.DEFAULT_OPTION);
        } catch (ExceptionBebidaJaCadastrada ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Bebida Já foi Cadastrada Patrão! ", "Bebida Já Cadastrada", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(ex);
            }
        }
    }



//    (ae) -> {
//            String nome = (String) JOptionPane.showInputDialog(this,
//            "Qual o nome da Bebida?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null);
//            int preco = Integer.parseInt((String) JOptionPane.showInputDialog(this,
//            "Qual o preço da Bebida?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null));
//            int quantidade = Integer.parseInt((String) JOptionPane.showInputDialog(this,
//            "Quantas Bebidas serão adicionadas?", "Cadastramento para Estoque", JOptionPane.DEFAULT_OPTION, addIcon, null, null));
//            boolean cadastrou = deposito.cadastraBebidas(nome, preco, quantidade);
//            if (cadastrou) {
//            JOptionPane.showMessageDialog(this,
//            "Bebida cadastrada","cadastramento", JOptionPane.DEFAULT_OPTION);
//            } else {
//            JOptionPane.showMessageDialog(this,
//            "Bebida não foi cadastrado. " +
//            "Verifique se já não existia", "cadastramento", JOptionPane.DEFAULT_OPTION);
//            }
//            }
