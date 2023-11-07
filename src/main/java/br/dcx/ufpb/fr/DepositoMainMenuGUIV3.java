package br.dcx.ufpb.fr;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class DepositoMainMenuGUIV3 extends JFrame {
    private Map<String, Bebidas> bebidas;
    private GravadorDeDados gravador = new GravadorDeDados();
    JLabel linha1, linha2;
    ImageIcon LogoLcc = new ImageIcon("./src/main/resources/logoBlack.png");

    DepositoFacade deposito;
    JMenuBar barraDeMenu = new JMenuBar();

    int mensagem = LogoEntrace.showMensage();

    ControllerDepositRecorder gravaBebidas;



    public DepositoMainMenuGUIV3() throws IOException {
        setTitle("Deposito de Bebidas LCC");
        setSize(1200, 1200);
        setLocation(400, 400);
        setResizable(true);
        getContentPane().setBackground(Color.darkGray);
        deposito = new DepositoFacade();
        gravaBebidas = new ControllerDepositRecorder(deposito, this);

        linha1 = new JLabel(" ", JLabel.CENTER);
//        linha1.setForeground(Color.WHITE);
//        linha1.setFont(new Font("SansSerif", Font.BOLD, 35));
        linha2 = new JLabel(LogoLcc, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(3, 2));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(new JLabel());

        //Menu Cadastrar....................................
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarBebida = new JMenuItem(
                "Cadastrar Bebidas");
        menuCadastrar.add(menuCadastrarBebida);
        //==================================================

        //Menu Pesquisar....................................
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarBebida = new JMenuItem(
                "Pesquisar Bebidas");
        menuPesquisar.add(menuPesquisarBebida);
        //==================================================

        //Menu Listar Estoque...............................
        JMenu menuListar = new JMenu("Estoque");
        JMenuItem menuListarEstoque = new JMenuItem(
                "Listar Estoque");
        menuListar.add(menuListarEstoque);
        //==================================================

        //Menu Salvar.......................................
        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarBebidas = new JMenuItem(
                "Salvar Bebidas");
        menuSalvar.add(menuSalvarBebidas);
        //==================================================

        //Menu Capacidade....................................
        JMenu menuCapacidade = new JMenu("Capacidade");
        JMenuItem menuCapacidadeEstoque = new JMenuItem(
                "Capacidade em Estoque");
        menuCapacidade.add(menuCapacidadeEstoque);
        //==================================================

        //Menu Remover......................................
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverBebida = new JMenuItem(
                "Remover Bebidas");
        menuRemover.add(menuRemoverBebida);
        //===================================================

        //Menu Sobre Nós.......................................
        JMenu menuSobre = new JMenu("Sobre");
        JMenuItem menuSobreNos = new JMenuItem(
                "Sobre Nós");
        menuSobre.add(menuSobreNos);
        //==================================================


        //Menu's AddActionListener's.........................
        menuCapacidadeEstoque.addActionListener(
                new ControllerDepositCapacity(deposito, this));

        menuListarEstoque.addActionListener(
                new ControllerDepositList(deposito, this));

        menuPesquisarBebida.addActionListener(
                new ControllerDepositSearch(deposito,this));

        menuRemoverBebida.addActionListener(
                new ControllerDepositRemove(deposito, this));

        menuCadastrarBebida.addActionListener(
                new ControllerDepositAdd(deposito, this));

        menuSobreNos.addActionListener(
                new ControllerDepositAboutUs(deposito, this));

        menuSalvarBebidas.addActionListener(
                new ControllerDepositRecorder(deposito, this));

        //deposito.recuperaAsBebidas();
        //gravador.salvarBebidas(deposito.getTodasAsBebidas());
       // gravador.recuperaBebidas();



        //Barras do Menu.......................................
        barraDeMenu.add(menuCadastrar);

        barraDeMenu.add(menuPesquisar);

        barraDeMenu.add(menuListar);

        barraDeMenu.add(menuRemover);

        barraDeMenu.add(menuCapacidade);

        barraDeMenu.add(menuSalvar);

        barraDeMenu.add(menuSobre);

        setJMenuBar(barraDeMenu);

    }


    public static void main(String [] args) throws IOException {
        JFrame janela = new DepositoMainMenuGUIV3();
        janela.setVisible(true);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
