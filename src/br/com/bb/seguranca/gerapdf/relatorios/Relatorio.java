package br.com.bb.seguranca.gerapdf.relatorios;

public interface Relatorio {

	public void gerarCabecalho();

	public void gerarCorpo();

	public void gerarRodape();

	public void imprimir();

}
