package br.com.orange.carteira.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransacaoRepository extends JpaRepository <Transacao, Long> {

}
