package br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;

import java.util.List;

public class DadosUsuario {

	public final TipoUsuario padrao;
	public final int idUsuario;

	public DadosUsuario(TipoUsuario padrao, int idUsuario) {
		this.padrao = padrao;
		this.idUsuario = idUsuario;
	}


	public static  TipoUsuario consulteUsuarioId(int idUsuario){
		if(1 == idUsuario){
			return TipoUsuario.PADRAO;
		}
		return TipoUsuario.PESQUISADOR;
	}

	public int quantidadeEsprestimoUsurioPadrao(List<EmprestimoConcedido> emprestimoConcedido){
		return emprestimoConcedido.size();
	}

}
