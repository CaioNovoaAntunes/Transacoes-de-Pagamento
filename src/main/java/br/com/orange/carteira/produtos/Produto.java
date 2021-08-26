package br.com.orange.carteira.produtos;

import br.com.orange.carteira.transacoes.Transacao;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Produto {
    String nome;
    String valor;
    @OneToMany
    Transacao transacao;


    public Produto(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }
    @Deprecated
    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }
}
