package br.com.orange.carteira.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository <Transacao, Long> {
}
