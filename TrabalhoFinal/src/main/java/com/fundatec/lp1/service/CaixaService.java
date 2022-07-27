package com.fundatec.lp1.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.ContaConverter;
import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.enums.TipoAcao;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.models.Movimentacao;
import com.fundatec.lp1.repository.ContaRepository;
import com.fundatec.lp1.repository.MovimentacaoRepository;
import com.fundatec.lp1.responseDTO.ResponseConta;
import com.fundatec.lp1.service.exceptions.ContaDesativadaException;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;
import com.fundatec.lp1.service.exceptions.SenhaInvalidaException;

@Service
public class CaixaService {

	@Autowired
	private ContaRepository repository;

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	public String consultarSaldo(Integer senha, Integer id) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo();
		return "Saldo da sua conta: " + saldo;
	}

	public ResponseConta depositar(Integer senha, Integer id, Double deposito) {
		TipoAcao acao = TipoAcao.DEPOSITO;
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo() + deposito;
		conta.setSaldo(saldo);
		gerarMovimentacao(conta, deposito, acao);
		repository.save(conta);
		return ContaConverter.converterParaResponseDTO(conta);
	}

	public String sacar(Integer senha, Integer id, Double saque) {
		TipoAcao acao = TipoAcao.SAQUE;
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo() - saque;
		conta.setSaldo(saldo);
		gerarMovimentacao(conta, saque, acao);
		repository.save(conta);
		return "Seu valor sacado: " + saque;
	}

	public List<Movimentacao> consultarExtrato(Integer senha, Integer id) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		List<Movimentacao> movimentacoes = conta.getMovimentacoes();
		return movimentacoes;
	}

	public void validar(Integer senha, Conta conta) {
		Integer senhaConta = conta.getSenha();
		if (senhaConta.intValue() != senha.intValue()) {
			throw new SenhaInvalidaException("Senha invalida");
		}
	}

	public void validarContaAtiva(StatusConta status) {
		if (status.equals(StatusConta.INATIVA)) {
			throw new ContaDesativadaException("Conta desativada");
		}
	}

	public void gerarMovimentacao(Conta conta, Double valor, TipoAcao acao) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		LocalDateTime horario = LocalDateTime.now();
		movimentacao.setHorario(horario);
		movimentacao.setDescricao(acao + " no valor: " + valor);
		movimentacaoRepository.save(movimentacao);
	}

}
