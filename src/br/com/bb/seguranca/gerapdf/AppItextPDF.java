package br.com.bb.seguranca.gerapdf;

import java.util.ArrayList;
import java.util.List;

import br.com.bb.seguranca.gerapdf.vendas.Produto;
import br.com.bb.seguranca.gerapdf.vendas.Venda;

public class AppItextPDF {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();

		Venda venda = new Venda("Jurandir Magalh�es", produtos);

		venda.addProdutosAoCarrinho(new Produto("Pinga", 2, 5.00));
		venda.addProdutosAoCarrinho(new Produto("P�o com mortadela", 1, 5.50));
		venda.addProdutosAoCarrinho(new Produto("Lingui�a", 2, 15.00));
		venda.addProdutosAoCarrinho(new Produto("Cerveja", 1, 9.90));

		

	}

}
