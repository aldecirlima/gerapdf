package br.com.bb.seguranca.gerapdf.vendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private LocalDate dataVenda;

	private String nomeCliente;

	private List<Produto> produtosVendidos;

	public Venda(LocalDate dataVenda, String nomeCliente, List<Produto> produtosVendidos) {
		this.dataVenda = dataVenda;
		this.nomeCliente = nomeCliente;
		this.produtosVendidos = produtosVendidos;
	}

	public Venda(String nomeCliente, List<Produto> produtosVendidos) {
		this.dataVenda = LocalDate.now();
		this.nomeCliente = nomeCliente;
		this.produtosVendidos = produtosVendidos;
	}

	public double calcularValorTotalDoCarrinho() {
		double total = 0;
		for (Produto produto : produtosVendidos) {
			total += produto.calcularPreco();
		}

		return total;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public List<Produto> getProdutosVendidos() {
		return produtosVendidos;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void addProdutosAoCarrinho(Produto produto) {
		if (produtosVendidos == null) {
			produtosVendidos = new ArrayList<Produto>();
		}
		this.produtosVendidos.add(produto);
	}

}
