package br.dcx.ufpb.fr;

import java.io.Serializable;
import java.util.Objects;

public class Bebidas implements Serializable {
    private String nomeDaBebida;
    private double precoDaBebida;
    private int quantBebidas;

    public Bebidas(String nomeDaBebida, double precoDaBebida, int quantBebidas) {
        this.nomeDaBebida = nomeDaBebida;
        this.precoDaBebida = precoDaBebida;
        this.quantBebidas= quantBebidas;
    }

    public int getQuantBebidas() {
        return quantBebidas;
    }

    public void setQuantBebidas(int quantBebidas) {
        this.quantBebidas = quantBebidas;
    }

    public String getNomeDaBebida() {
        return nomeDaBebida;
    }

    public void setNomeDaBebida(String nomeDaBebida) {
        this.nomeDaBebida = nomeDaBebida;
    }

    public double getPrecoDaBebida() {
        return precoDaBebida;
    }

    public void setPrecoDaBebida(double precoDaBebida) {
        this.precoDaBebida = precoDaBebida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bebidas bebidas)) return false;
        return Double.compare(bebidas.precoDaBebida, precoDaBebida) == 0 && quantBebidas == bebidas.quantBebidas && Objects.equals(nomeDaBebida, bebidas.nomeDaBebida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDaBebida, precoDaBebida, quantBebidas);
    }

    @Override
    public String toString() {
        return  " Nome: " + nomeDaBebida +
                "\n   Preco: " + precoDaBebida +
                "\n   Quantidade em Estoque: " + quantBebidas + "\n========================\n";
    }
}
