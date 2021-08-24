package br.com.orange.carteira.estabelecimentos;

import br.com.orange.carteira.validadores.customizado.CPF_CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class NovoEstabelecimento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        @Column(nullable = false)
        String documento;
        @Column(nullable = false)
        String nome;

    public NovoEstabelecimento(String cpnpj, String nome) {
        this.documento = cpnpj;
        this.nome = nome;
    }
    @Deprecated
    public NovoEstabelecimento() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
