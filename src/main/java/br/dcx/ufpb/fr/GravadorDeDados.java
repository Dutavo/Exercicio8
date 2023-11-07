package br.dcx.ufpb.fr;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVO_BEBIDAS = "bebidas.txt";

    public HashMap<String, Bebidas> recuperaBebidas() throws IOException{
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_BEBIDAS));
            return (HashMap<String, Bebidas>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as bebidas salvas");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_BEBIDAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }

    }
    public void salvarBebidas(Map<String, Bebidas> bebidas) throws IOException{

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BEBIDAS));
            out.writeObject(bebidas);
            System.out.println("salvou");
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar as bebidas no arquivo "+ARQUIVO_BEBIDAS);
        }finally{
            if(out != null){
                out.close();
            }
        }

    }





}
