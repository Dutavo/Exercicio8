package br.dcx.ufpb.fr;
import static org.junit.jupiter.api.Assertions.*;

import org.testng.annotations.Test;

import java.io.File;

public class TestaDeposito {
    @Test
    public void TestaCasdastroDeposito() {
        DepositoFacade depositoLcc = new DepositoFacade();
        try {
            depositoLcc.cadastraBebidas("Ice", 5.0, 10);
        } catch (ExceptionBebidaJaCadastrada e) {
            fail("Não deveria lançar exceção");
        }
        try {
            depositoLcc.cadastraBebidas("Ice", 5.0, 10);
            fail("Deveria ter lançado a execeção ao cadastra a bebida novamente");
        } catch (ExceptionBebidaJaCadastrada e) {
            //OK
        }
    }

    @Test
    public void TestaPesquisaBebidas() {
        DepositoFacade depositoLcc = new DepositoFacade();
        try {
            depositoLcc.cadastraBebidas("Cerveja", 3.50, 10);
            depositoLcc.cadastraBebidas("Vinho", 30.00, 15);
            assertEquals(1, depositoLcc.pesquisaBebidas("Cerveja").size());
        } catch (ExceptionBebidaJaCadastrada e) {
            fail("Não deveria lançar execeção");
        }try{
            depositoLcc.cadastraBebidas("Cerveja",4.50, 24);
        }catch (ExceptionBebidaJaCadastrada e){
            //ok
        }

    }
    @Test
    public void TestaListarBebidas(){
        DepositoFacade depositoLcc= new DepositoFacade();
        assertEquals(0,depositoLcc.listarBebidas().size());
        try{
            depositoLcc.cadastraBebidas("Matuta", 15.00, 5);
            depositoLcc.cadastraBebidas("Vinho", 30.00, 15);
            depositoLcc.cadastraBebidas("Bhama", 5.00, 24);
            assertEquals(3,depositoLcc.listarBebidas().size());
        }catch (ExceptionBebidaJaCadastrada e){
            fail("Não deveria lançar execeção");
        }
    }
    @Test
    public void TestaGravador(){
        File f= new File(GravadorDeDados.ARQUIVO_BEBIDAS);
        if(f.exists()){
            f.delete();
        }
        DepositoFacade depositoLcc= new DepositoFacade();
        try {
            depositoLcc.cadastraBebidas("Vinho Tinto", 45.00, 10);
            depositoLcc.salvarAsBebidas();
            assertEquals(1,depositoLcc.pesquisaBebidas("Vinho Tinto").size());
            assertTrue(f.exists());
            f.delete();
        }catch (ExceptionBebidaJaCadastrada e){
            //ok

        }

    }
    @Test
    public void TestRemoverBebidas() {
        DepositoFacade depositoLcc = new DepositoFacade();
        try {
            depositoLcc.cadastraBebidas("Vinho Branco", 80.00, 20);
            depositoLcc.cadastraBebidas("Whisky Royal Salutte", 250.00, 10);
            assertEquals(3, depositoLcc.listarBebidas().size());
            depositoLcc.removeBebidas("Vinho Branco");
            assertEquals(2, depositoLcc.listarBebidas().size());
        } catch (ExceptionBebidaJaCadastrada e) {
            //ok

        }
    }
}