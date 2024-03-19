package br.com.bb.seguranca.gerapdf;

import java.util.ArrayList;
import java.util.List;

import br.com.bb.seguranca.gerapdf.relatorios.Relatorio;
import br.com.bb.seguranca.gerapdf.relatorios.RelatorioPdfSimples;
import br.com.bb.seguranca.gerapdf.vendas.Produto;
import br.com.bb.seguranca.gerapdf.vendas.Venda;

public class AppRelatorioSimples {

	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();

		Venda venda = new Venda("Jurandir Magalhães", produtos);
		
		venda.addProdutosAoCarrinho(new Produto("Pinga", 2, 0.10));
		venda.addProdutosAoCarrinho(new Produto("Pão com mortadela", 1, 1.0));
		venda.addProdutosAoCarrinho(new Produto("Linguiça", 2, 0.90));
		
		Relatorio relatorioSimples = new RelatorioPdfSimples(venda);
		
		relatorioSimples.gerarCabecalho();
		relatorioSimples.gerarCorpo();
		relatorioSimples.gerarRodape();
		relatorioSimples.imprimir();
		
	}

}
