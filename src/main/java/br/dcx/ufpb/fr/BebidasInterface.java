package br.dcx.ufpb.fr;

import java.util.Collection;

public interface BebidasInterface {
    public boolean cadastraBebidas(String nomeDaBebida, double precoDaUnidade, int quantBebidas) throws ExceptionBebidaJaCadastrada;
    public Collection<Bebidas> pesquisaBebidas(String nomeDaBebida);
    public boolean removeBebidas(String nomeDaBebida);
    public Collection<Bebidas> listarBebidas();
    public int capacidadeDoEstoque() throws ExceptionCapacidadeCheia;
    public void recuperaAsBebidas();
    public void salvarAsBebidas();
}
