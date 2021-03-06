package br.com.zup.edu.ligaqualidade.desafiobiblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosLivro;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

public class Main {

	public static int DIAS_60 = 60;
	public static int DIAS_61 = 61;
	public static int DIAS_10 = 10;

	public static Set<DadosLivro> livros = new HashSet<>();
	public static Set<DadosExemplar> exemplares = new HashSet<>();
	public static Set<DadosUsuario> usuarios = new HashSet<>();
	public static Set<DadosEmprestimo> emprestimos = new HashSet<>();
	public static Set<DadosDevolucao> devolucoes = new HashSet<>();
	public static LocalDate dataParaSerConsideradaNaExpiracao;

	public static void main(String[] args) {
		/*
		 * Cenario 1
		 * 
		 *  - Usuario padrão pede 5 exemplares livres diferentes para 60 dias
		 *  - Retorno: 5 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 *  
		 *  Cenario 2
		 *  
		 *  - Usuario pesquisador pede 6 exemplares restritos diferentes para 60 dias
		 *  - Retorno: 6 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 *  
		 *  Cenario 3
		 *  
		 *  - Usuario padrão pede 4 exemplares livres diferentes e 1 restrito para 60 dias
		 *  - Retorno: 4 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 *  
		 *  Cenario 4
		 *  
		 *  - Usuario pesquisador pede 4 exemplares livres diferentes e 2 restrito para 60 dias
		 *  - Retorno: 6 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 *  
		 *  Cenario 5
		 *  
		 *  - Usuario pesquisador pede 5 exemplares diferentes para 61 dias
		 *  - Retorno: 0 emprestimos concedidos 
		 *  
		 *  
		 *  Cenario 6
		 *  
		 *  - Usuario padrao pede 1 exemplar livre para 10 dias
		 *  - Dez dias se passaram
		 *  - Usuario padrao pede 1 exemplar livre diferente para 10 dias
		 *  - Retorno: 1 empréstimo concedido para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução 
		 *  
		 *  Cenario 7
		 *  
		 *  - Usuario padrao pede 5 exemplares livres para 10 dias
		 *  - Usuario devolve o primeiro o livro 5 dias depois
		 *  - Retorno: 5 empréstimo concedidos e um devolvido para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 */
		
		/*
		 * 
		 */

		LocalDate dataManipulacao = LocalDate.now();

		/* Cenario 1
				*
		 *  - Usuario padrão pede 5 exemplares livres diferentes para 60 dias
		 *  - Retorno: 5 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		 *
		 */
		DadosUsuario usuario1 = new DadosUsuario(TipoUsuario.PADRAO,1);

		// determinado exemplar
		DadosLivro livro1 = new DadosLivro("Java como Programar",BigDecimal.valueOf(250),1);
		DadosLivro livro2 = new DadosLivro("Java Estruturado",BigDecimal.valueOf(150),2);
		DadosLivro livro3 = new DadosLivro("Algoritmos",BigDecimal.valueOf(200),3);
		DadosLivro livro4 = new DadosLivro("Java para Leigos",BigDecimal.valueOf(200),4);
		DadosLivro livro5 = new DadosLivro("JPA 2",BigDecimal.valueOf(200),5);

		// determinado exemplar
		DadosExemplar exemplar1 = new DadosExemplar(TipoExemplar.LIVRE,livro1.id,1);
		DadosExemplar exemplar2 = new DadosExemplar(TipoExemplar.LIVRE,livro2.id,2);
		DadosExemplar exemplar3 = new DadosExemplar(TipoExemplar.LIVRE,livro3.id,3);
		DadosExemplar exemplar4 = new DadosExemplar(TipoExemplar.LIVRE,livro4.id,4);
		DadosExemplar exemplar5 = new DadosExemplar(TipoExemplar.LIVRE,livro5.id,5);

		DadosEmprestimo emprestimo1 = new DadosEmprestimo(exemplar1.idLivro,usuario1.idUsuario, DIAS_60,TipoExemplar.LIVRE,1);
		DadosEmprestimo emprestimo2 = new DadosEmprestimo(exemplar2.idLivro,usuario1.idUsuario, DIAS_60,TipoExemplar.LIVRE,2);
		DadosEmprestimo emprestimo3 = new DadosEmprestimo(exemplar3.idLivro,usuario1.idUsuario, DIAS_60,TipoExemplar.LIVRE,3);
		DadosEmprestimo emprestimo4 = new DadosEmprestimo(exemplar4.idLivro,usuario1.idUsuario, DIAS_60,TipoExemplar.LIVRE,4);
		DadosEmprestimo emprestimo5 = new DadosEmprestimo(exemplar5.idLivro,usuario1.idUsuario, DIAS_60,TipoExemplar.LIVRE,5);

		// sem data instante de devolução
		DadosDevolucao dadosDevolucao1 = new DadosDevolucao(emprestimo1.idPedido,null);
		DadosDevolucao dadosDevolucao2 = new DadosDevolucao(emprestimo2.idPedido,null);
		DadosDevolucao dadosDevolucao3 = new DadosDevolucao(emprestimo3.idPedido,null);
		DadosDevolucao dadosDevolucao4 = new DadosDevolucao(emprestimo4.idPedido,null);
		DadosDevolucao dadosDevolucao5 = new DadosDevolucao(emprestimo5.idPedido,null);

		// 5 emprestimos concedidos para o determinado usuario - data prevista de devolução
		EmprestimoConcedido emprConcedido1 = new EmprestimoConcedido(usuario1.idUsuario,exemplar1.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido2 = new EmprestimoConcedido(usuario1.idUsuario,exemplar2.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido3 = new EmprestimoConcedido(usuario1.idUsuario,exemplar3.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido4 = new EmprestimoConcedido(usuario1.idUsuario,exemplar4.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido5 = new EmprestimoConcedido(usuario1.idUsuario,exemplar5.idExemplar,
				dataManipulacao.plusDays(DIAS_60));


		 /*  Cenario 2
		*
		*  - Usuario pesquisador pede 6 exemplares restritos diferentes para 60 dias
		*  - Retorno: 6 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
		*/
		DadosUsuario usuario2 = new DadosUsuario(TipoUsuario.PESQUISADOR,2);

		DadosLivro livro6 = new DadosLivro("Java Efetivo: as Melhores Práticas Para a Plataforma Java"
				,BigDecimal.valueOf(59),6);
		DadosLivro livro7 = new DadosLivro("Estruturas de Dados & Algoritmos em Java",BigDecimal.valueOf(270),7);
		DadosLivro livro8 = new DadosLivro("Use a Cabeça!: Java",BigDecimal.valueOf(138),8);
		DadosLivro livro9 = new DadosLivro("Programação Funcional Para Desenvolvedores Java",
				BigDecimal.valueOf(39),4);
		DadosLivro livro10 = new DadosLivro("Java 7 - Ensino didático",BigDecimal.valueOf(110),5);
		DadosLivro livro11 = new DadosLivro("Introdução ao Hibernate",BigDecimal.valueOf(36),5);

		// determinado exemplar
		DadosExemplar exemplar6   = new DadosExemplar(TipoExemplar.RESTRITO,livro6.id,6);
		DadosExemplar exemplar7   = new DadosExemplar(TipoExemplar.RESTRITO,livro7.id,7);
		DadosExemplar exemplar8   = new DadosExemplar(TipoExemplar.RESTRITO,livro8.id,8);
		DadosExemplar exemplar9   = new DadosExemplar(TipoExemplar.RESTRITO,livro9.id,9);
		DadosExemplar exemplar10  = new DadosExemplar(TipoExemplar.RESTRITO,livro10.id,10);
		DadosExemplar exemplar11  = new DadosExemplar(TipoExemplar.RESTRITO,livro11.id,11);

		DadosEmprestimo emprestimo6  = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,6);
		DadosEmprestimo emprestimo7  = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,7);
		DadosEmprestimo emprestimo8  = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,8);
		DadosEmprestimo emprestimo9  = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,9);
		DadosEmprestimo emprestimo10 = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,10);
		DadosEmprestimo emprestimo11 = new DadosEmprestimo(exemplar6.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,11);

		EmprestimoConcedido emprConcedido6 = new EmprestimoConcedido(usuario2.idUsuario,exemplar6.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido7 = new EmprestimoConcedido(usuario2.idUsuario,exemplar7.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido8 = new EmprestimoConcedido(usuario2.idUsuario,exemplar8.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido9 = new EmprestimoConcedido(usuario2.idUsuario,exemplar9.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido10 = new EmprestimoConcedido(usuario2.idUsuario,exemplar10.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido11 = new EmprestimoConcedido(usuario2.idUsuario,exemplar11.idExemplar,
				dataManipulacao.plusDays(DIAS_60));

		// sem data instante de devolução
		DadosDevolucao dadosDevolucao6  = new DadosDevolucao(emprestimo6.idPedido,null);
		DadosDevolucao dadosDevolucao7  = new DadosDevolucao(emprestimo7.idPedido,null);
		DadosDevolucao dadosDevolucao8  = new DadosDevolucao(emprestimo8.idPedido,null);
		DadosDevolucao dadosDevolucao9  = new DadosDevolucao(emprestimo9.idPedido,null);
		DadosDevolucao dadosDevolucao10 = new DadosDevolucao(emprestimo10.idPedido,null);
		DadosDevolucao dadosDevolucao11 = new DadosDevolucao(emprestimo11.idPedido,null);


		/*  Cenario 3
				*
		 *  - Usuario padrão pede 4 exemplares livres diferentes e 1 restrito para 60 dias
				*  - Retorno: 4 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
				*/

		DadosExemplar exemplar12   = new DadosExemplar(TipoExemplar.LIVRE,livro6.id,12);
		DadosExemplar exemplar13   = new DadosExemplar(TipoExemplar.LIVRE,livro7.id,13);
		DadosExemplar exemplar14   = new DadosExemplar(TipoExemplar.LIVRE,livro8.id,14);
		DadosExemplar exemplar15   = new DadosExemplar(TipoExemplar.RESTRITO,livro9.id,15);

		DadosEmprestimo emprestimo12  = new DadosEmprestimo(exemplar12.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,12);
		DadosEmprestimo emprestimo13  = new DadosEmprestimo(exemplar13.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,13);
		DadosEmprestimo emprestimo14  = new DadosEmprestimo(exemplar14.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,14);
		DadosEmprestimo emprestimo15  = new DadosEmprestimo(exemplar15.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.RESTRITO,15);

		EmprestimoConcedido emprConcedido12 = new EmprestimoConcedido(usuario1.idUsuario,exemplar12.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido13 = new EmprestimoConcedido(usuario1.idUsuario,exemplar13.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido14 = new EmprestimoConcedido(usuario1.idUsuario,exemplar14.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido15 = new EmprestimoConcedido(usuario1.idUsuario,exemplar15.idExemplar,
				dataManipulacao.plusDays(DIAS_60));

		// sem data instante de devolução
		DadosDevolucao dadosDevolucao12  = new DadosDevolucao(emprestimo12.idPedido,null);
		DadosDevolucao dadosDevolucao13  = new DadosDevolucao(emprestimo13.idPedido,null);
		DadosDevolucao dadosDevolucao14  = new DadosDevolucao(emprestimo14.idPedido,null);
		DadosDevolucao dadosDevolucao15  = new DadosDevolucao(emprestimo15.idPedido,null);



		 /*  Cenario 4
				*
	    *  - Usuario pesquisador pede 4 exemplares livres diferentes e 2 restrito para 60 dias
		*  - Retorno: 6 emprestimos concedidos para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
				*/

		// determinado exemplar
		DadosExemplar exemplar16   = new DadosExemplar(TipoExemplar.LIVRE,livro6.id,16);
		DadosExemplar exemplar17   = new DadosExemplar(TipoExemplar.LIVRE,livro7.id,17);
		DadosExemplar exemplar18   = new DadosExemplar(TipoExemplar.LIVRE,livro8.id,18);
		DadosExemplar exemplar19   = new DadosExemplar(TipoExemplar.LIVRE,livro9.id,19);
		DadosExemplar exemplar20   = new DadosExemplar(TipoExemplar.RESTRITO,livro10.id,20);
		DadosExemplar exemplar21   = new DadosExemplar(TipoExemplar.RESTRITO,livro11.id,21);

		DadosEmprestimo emprestimo16  = new DadosEmprestimo(exemplar16.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,16);
		DadosEmprestimo emprestimo17  = new DadosEmprestimo(exemplar17.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,17);
		DadosEmprestimo emprestimo18  = new DadosEmprestimo(exemplar18.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,18);
		DadosEmprestimo emprestimo19  = new DadosEmprestimo(exemplar19.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,19);
		DadosEmprestimo emprestimo20  = new DadosEmprestimo(exemplar20.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,20);
		DadosEmprestimo emprestimo21  = new DadosEmprestimo(exemplar21.idLivro,usuario2.idUsuario, DIAS_60,TipoExemplar.LIVRE,21);


		EmprestimoConcedido emprConcedido16 = new EmprestimoConcedido(usuario2.idUsuario,exemplar16.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido17 = new EmprestimoConcedido(usuario2.idUsuario,exemplar17.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido18 = new EmprestimoConcedido(usuario2.idUsuario,exemplar18.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido19 = new EmprestimoConcedido(usuario2.idUsuario,exemplar19.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido20 = new EmprestimoConcedido(usuario2.idUsuario,exemplar20.idExemplar,
				dataManipulacao.plusDays(DIAS_60));
		EmprestimoConcedido emprConcedido21 = new EmprestimoConcedido(usuario2.idUsuario,exemplar21.idExemplar,
				dataManipulacao.plusDays(DIAS_60));

		// sem data instante de devolução
		DadosDevolucao dadosDevolucao16  = new DadosDevolucao(emprestimo16.idPedido,null);
		DadosDevolucao dadosDevolucao17  = new DadosDevolucao(emprestimo17.idPedido,null);
		DadosDevolucao dadosDevolucao18  = new DadosDevolucao(emprestimo18.idPedido,null);
		DadosDevolucao dadosDevolucao19  = new DadosDevolucao(emprestimo19.idPedido,null);
		DadosDevolucao dadosDevolucao20  = new DadosDevolucao(emprestimo20.idPedido,null);
		DadosDevolucao dadosDevolucao21  = new DadosDevolucao(emprestimo21.idPedido,null);


		 /*  Cenario 5
				*
		 *  - Usuario pesquisador pede 5 exemplares diferentes para 61 dias
				*  - Retorno: 0 emprestimos concedidos
		 *
		 */

		// determinado exemplar
		DadosExemplar exemplar22   = new DadosExemplar(TipoExemplar.LIVRE,livro6.id,22);
		DadosExemplar exemplar23   = new DadosExemplar(TipoExemplar.LIVRE,livro7.id,23);
		DadosExemplar exemplar24   = new DadosExemplar(TipoExemplar.LIVRE,livro8.id,24);
		DadosExemplar exemplar25   = new DadosExemplar(TipoExemplar.LIVRE,livro9.id,25);
		DadosExemplar exemplar26   = new DadosExemplar(TipoExemplar.LIVRE,livro10.id,26);

		DadosEmprestimo emprestimo22  = new DadosEmprestimo(exemplar22.idLivro,usuario2.idUsuario, DIAS_61,TipoExemplar.LIVRE,22);
		DadosEmprestimo emprestimo23  = new DadosEmprestimo(exemplar23.idLivro,usuario2.idUsuario, DIAS_61,TipoExemplar.LIVRE,23);
		DadosEmprestimo emprestimo24  = new DadosEmprestimo(exemplar24.idLivro,usuario2.idUsuario, DIAS_61,TipoExemplar.LIVRE,24);
		DadosEmprestimo emprestimo25  = new DadosEmprestimo(exemplar25.idLivro,usuario2.idUsuario, DIAS_61,TipoExemplar.LIVRE,25);
		DadosEmprestimo emprestimo26  = new DadosEmprestimo(exemplar26.idLivro,usuario2.idUsuario, DIAS_61,TipoExemplar.LIVRE,26);



		 /*  Cenario 6
				*
		 *  - Usuario padrao pede 1 exemplar livre para 10 dias
				*  - Dez dias se passaram
				*  - Usuario padrao pede 1 exemplar livre diferente para 10 dias
				*  - Retorno: 1 empréstimo concedido para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
				*/

		DadosExemplar exemplar27   = new DadosExemplar(TipoExemplar.LIVRE,livro4.id,27);
		DadosExemplar exemplar28   = new DadosExemplar(TipoExemplar.LIVRE,livro3.id,28);

		DadosEmprestimo emprestimo27  = new DadosEmprestimo(exemplar27.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,27);

		DadosEmprestimo emprestimo28  = new DadosEmprestimo(exemplar28.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,28);

		EmprestimoConcedido emprConcedido27 = new EmprestimoConcedido(usuario1.idUsuario,exemplar28.idExemplar,
				dataManipulacao.plusDays(DIAS_60));

		DadosDevolucao dadosDevolucao27  = new DadosDevolucao(emprestimo28.idPedido,null);


		/*  *  Cenario 7
				*
		 *  - Usuario padrao pede 5 exemplares livres para 10 dias
				*  - Usuario devolve o primeiro o livro 5 dias depois
		 *  - Retorno: 5 empréstimo concedidos e um devolvido para o determinado usuario, determinado exemplar, data prevista de devolução e sem data instante de devolução
				*/


		// determinado exemplar
		DadosExemplar exemplar29 = new DadosExemplar(TipoExemplar.LIVRE,livro1.id,29);
		DadosExemplar exemplar30 = new DadosExemplar(TipoExemplar.LIVRE,livro2.id,30);
		DadosExemplar exemplar31 = new DadosExemplar(TipoExemplar.LIVRE,livro3.id,31);
		DadosExemplar exemplar32 = new DadosExemplar(TipoExemplar.LIVRE,livro4.id,32);
		DadosExemplar exemplar33 = new DadosExemplar(TipoExemplar.LIVRE,livro5.id,33);

		DadosEmprestimo emprestimo29 = new DadosEmprestimo(exemplar29.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,29);
		DadosEmprestimo emprestimo30 = new DadosEmprestimo(exemplar30.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,30);
		DadosEmprestimo emprestimo31 = new DadosEmprestimo(exemplar31.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,31);
		DadosEmprestimo emprestimo32 = new DadosEmprestimo(exemplar32.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,32);
		DadosEmprestimo emprestimo33 = new DadosEmprestimo(exemplar33.idLivro,usuario1.idUsuario, DIAS_10,TipoExemplar.LIVRE,33);

		// 5 emprestimos concedidos para o determinado usuario - data prevista de devolução
		EmprestimoConcedido emprConcedido29 = new EmprestimoConcedido(usuario1.idUsuario,exemplar29.idExemplar,
				dataManipulacao.plusDays(DIAS_10));
		EmprestimoConcedido emprConcedido30 = new EmprestimoConcedido(usuario1.idUsuario,exemplar30.idExemplar,
				dataManipulacao.plusDays(DIAS_10));
		EmprestimoConcedido emprConcedido31 = new EmprestimoConcedido(usuario1.idUsuario,exemplar31.idExemplar,
				dataManipulacao.plusDays(DIAS_10));
		EmprestimoConcedido emprConcedido32 = new EmprestimoConcedido(usuario1.idUsuario,exemplar32.idExemplar,
				dataManipulacao.plusDays(DIAS_10));
		EmprestimoConcedido emprConcedido33 = new EmprestimoConcedido(usuario1.idUsuario,exemplar33.idExemplar,
				dataManipulacao.plusDays(DIAS_10));

		// sem data instante de devolução
		DadosDevolucao dadosDevolucao129 = new DadosDevolucao(emprestimo29.idPedido,dataManipulacao.plusDays(5));


		usuarios.add(usuario1);
		usuarios.add(usuario2);

		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		livros.add(livro4);
		livros.add(livro5);
		livros.add(livro6);
		livros.add(livro7);
		livros.add(livro8);
		livros.add(livro9);
		livros.add(livro10);
		livros.add(livro11);

		exemplares.add(exemplar1);
		exemplares.add(exemplar2);
		exemplares.add(exemplar3);
		exemplares.add(exemplar4);
		exemplares.add(exemplar5);
		exemplares.add(exemplar6);
		exemplares.add(exemplar7);
		exemplares.add(exemplar8);
		exemplares.add(exemplar9);
		exemplares.add(exemplar10);
		exemplares.add(exemplar11);
		exemplares.add(exemplar12);
		exemplares.add(exemplar13);
		exemplares.add(exemplar14);
		exemplares.add(exemplar15);
		exemplares.add(exemplar16);
		exemplares.add(exemplar17);
		exemplares.add(exemplar18);
		exemplares.add(exemplar19);
		exemplares.add(exemplar20);
		exemplares.add(exemplar21);
		exemplares.add(exemplar22);
		exemplares.add(exemplar23);
		exemplares.add(exemplar24);
		exemplares.add(exemplar25);
		exemplares.add(exemplar26);
		exemplares.add(exemplar27);
		exemplares.add(exemplar28);
		exemplares.add(exemplar29);
		exemplares.add(exemplar30);
		exemplares.add(exemplar31);
		exemplares.add(exemplar32);
		exemplares.add(exemplar33);


		emprestimos.add(emprestimo1);
		emprestimos.add(emprestimo2);
		emprestimos.add(emprestimo3);
		emprestimos.add(emprestimo4);
		emprestimos.add(emprestimo5);
		emprestimos.add(emprestimo6);
		emprestimos.add(emprestimo7);
		emprestimos.add(emprestimo8);
		emprestimos.add(emprestimo9);
		emprestimos.add(emprestimo10);
		emprestimos.add(emprestimo11);
		emprestimos.add(emprestimo12);
		emprestimos.add(emprestimo13);
		emprestimos.add(emprestimo14);
		emprestimos.add(emprestimo15);
		emprestimos.add(emprestimo16);
		emprestimos.add(emprestimo17);
		emprestimos.add(emprestimo18);
		emprestimos.add(emprestimo19);
		emprestimos.add(emprestimo20);
		emprestimos.add(emprestimo21);
		emprestimos.add(emprestimo22);
		emprestimos.add(emprestimo23);
		emprestimos.add(emprestimo24);
		emprestimos.add(emprestimo25);
		emprestimos.add(emprestimo26);
		emprestimos.add(emprestimo27);
		emprestimos.add(emprestimo28);
		emprestimos.add(emprestimo29);
		emprestimos.add(emprestimo30);
		emprestimos.add(emprestimo31);
		emprestimos.add(emprestimo32);
		emprestimos.add(emprestimo33);

		devolucoes.add(dadosDevolucao1);
		devolucoes.add(dadosDevolucao2);
		devolucoes.add(dadosDevolucao3);
		devolucoes.add(dadosDevolucao4);
		devolucoes.add(dadosDevolucao5);
		devolucoes.add(dadosDevolucao6);
		devolucoes.add(dadosDevolucao7);
		devolucoes.add(dadosDevolucao8);
		devolucoes.add(dadosDevolucao9);
		devolucoes.add(dadosDevolucao10);
		devolucoes.add(dadosDevolucao11);
		devolucoes.add(dadosDevolucao12);
		devolucoes.add(dadosDevolucao13);
		devolucoes.add(dadosDevolucao14);
		devolucoes.add(dadosDevolucao15);
		devolucoes.add(dadosDevolucao16);
		devolucoes.add(dadosDevolucao17);
		devolucoes.add(dadosDevolucao18);
		devolucoes.add(dadosDevolucao19);
		devolucoes.add(dadosDevolucao20);
		devolucoes.add(dadosDevolucao21);

		dataParaSerConsideradaNaExpiracao = dataManipulacao.plusDays(15);

	}


}
