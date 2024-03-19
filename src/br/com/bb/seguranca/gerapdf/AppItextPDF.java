package br.com.bb.seguranca.gerapdf;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

import br.com.bb.seguranca.gerapdf.relatorios.RelatorioItextVendas;
import br.com.bb.seguranca.gerapdf.vendas.Produto;
import br.com.bb.seguranca.gerapdf.vendas.Venda;

public class AppItextPDF {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();

		Venda venda = new Venda("Jurandir Magalhães", produtos);
		
		venda.addProdutosAoCarrinho(new Produto("Pinga", 2, 5.00));
		venda.addProdutosAoCarrinho(new Produto("Pão com mortadela", 1, 5.50));
		venda.addProdutosAoCarrinho(new Produto("Linguiça", 2, 15.00));
		venda.addProdutosAoCarrinho(new Produto("Cerveja", 1, 9.90));
		
		RelatorioItextVendas rel = new RelatorioItextVendas(venda);
		
		try {
			rel.geraRelatorio();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} 

	}

}
