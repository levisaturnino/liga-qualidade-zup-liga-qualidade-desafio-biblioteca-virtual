package br.com.zup.edu.ligaqualidade.desafiobiblioteca;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

public class EmprestimoConcedido {

	// id do emprestimo referenciado no PedidoEmprestimo
	public final int idUsuario;
	public final int idExemplar;
	// data em função do tempo de emprestimo
	public final LocalDate dataPrevistaDevolucao;
	// instante da devolução
	private Instant momentoDevolucao;

	public static int emprestimoPadrao = 0;

	/**
	 * 
	 * @param idUsuario id referente ao {@link DadosUsuario}
	 * @param idExemplar id referente ao {@link DadosExemplar}
	 * @param dataPrevistaDevolucao data prevista para devolução em função do número de dias
	 */
	public EmprestimoConcedido(int idUsuario,int idExemplar ,LocalDate dataPrevistaDevolucao) {
		super();
		this.idUsuario = idUsuario;
		this.idExemplar = idExemplar;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;

		if(DadosUsuario.consulteUsuarioId(idUsuario) == TipoUsuario.PADRAO){
			if(emprestimoPadrao >= 0  && emprestimoPadrao <= 5 ){
				emprestimoPadrao += 1;
			}else{
			//	throw new IllegalStateException("Você não pode pegar mais livro emprestado");
			}
		}
	}
	
	public void registraDevolucao() {
		this.momentoDevolucao = Instant.now();
	}
	
	
	public Optional<Instant> getMomentoDevolucao(){
		return Optional.ofNullable(this.momentoDevolucao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPrevistaDevolucao == null) ? 0
				: dataPrevistaDevolucao.hashCode());
		result = prime * result + idExemplar;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmprestimoConcedido other = (EmprestimoConcedido) obj;
		if (dataPrevistaDevolucao == null) {
			if (other.dataPrevistaDevolucao != null)
				return false;
		} else if (!dataPrevistaDevolucao.equals(other.dataPrevistaDevolucao))
			return false;
		if (idExemplar != other.idExemplar)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
	
	


}
