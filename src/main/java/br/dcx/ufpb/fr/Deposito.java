package br.dcx.ufpb.fr;

import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class Deposito implements BebidasInterface {
    private Map<String, Bebidas> bebidas;
    private GravadorDeDados gravador;


    public Deposito(){
        try {
            this.bebidas = new HashMap<>();
            this.gravador= new GravadorDeDados();
            this.bebidas = gravador.recuperaBebidas();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }



    }
    public void salvarAsBebidas(){
        try{
            gravador.salvarBebidas(bebidas);
        }catch (Exception e){

            System.err.println(e.getMessage());
        }
    }

    public void recuperaAsBebidas(){
        try {
            this.bebidas = gravador.recuperaBebidas();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastraBebidas(String nomeDaBebida, double precoDaUnidade, int quantBebidas) throws ExceptionBebidaJaCadastrada {
        if( !bebidas.containsKey(nomeDaBebida)){
            this.bebidas.put(nomeDaBebida, new Bebidas(nomeDaBebida, precoDaUnidade, quantBebidas));
            return true;
        }else{
            throw new ExceptionBebidaJaCadastrada("Bebida Já foi Cadastrada Patrão!");
        }
    }

    @Override
    public Collection<Bebidas> pesquisaBebidas(String nomeDaBebida) {
        Collection<Bebidas> BBsAchadas = new ArrayList<>();
        for (Bebidas b: this.bebidas.values()){
            if(b.getNomeDaBebida().equals(nomeDaBebida)){
                BBsAchadas.add(b);
            }
        }
        return BBsAchadas;
    }

    @Override
    public boolean removeBebidas(String nomeDaBebida) {
        if(this.bebidas.containsKey(nomeDaBebida)){
            this.bebidas.remove(nomeDaBebida);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection<Bebidas> listarBebidas() {
        Collection<Bebidas> listar = new ArrayList<>();
        for (Bebidas l: this.bebidas.values()){
            listar.add(l);
        }
        return listar;
    }

    @Override
    public int capacidadeDoEstoque() throws ExceptionCapacidadeCheia {
        int QuantTotal = 0;
        for(Bebidas t : bebidas.values()){
            QuantTotal += t.getQuantBebidas();
        }
        if(QuantTotal > 500) {
            throw new ExceptionCapacidadeCheia("Capacidade de Estoque Cheio");
        }
        return QuantTotal;
    }
    public Map<String,Bebidas> getTodasAsBebidas(){
        return this.bebidas;
    }
}
