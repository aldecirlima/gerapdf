package br.com.bb.seguranca.gerapdf.relatorios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Element;

import br.com.bb.seguranca.gerapdf.vendas.Produto;
import br.com.bb.seguranca.gerapdf.vendas.Venda;

public class RelatorioItextVendas {

	private static String PATH = "C:/JAVA/pdf/";

	private Venda venda;

	public RelatorioItextVendas(Venda venda) {
		this.venda = venda;
	}

	public void geraRelatorio() throws DocumentException, FileNotFoundException {
		Document documento = new Document();
		OutputStream output = new FileOutputStream(PATH + "RelatorioItext.pdf");
		PdfWriter.getInstance(documento, output);
		documento.open();
		Paragraph titulo = new Paragraph("LISTA DE ITENS VENDIDOS",
				new Font(FontFamily.TIMES_ROMAN, 18, Font.NORMAL, new BaseColor(107, 208, 182)));
		titulo.setAlignment(Element.ALIGN_CENTER);
		documento.add(titulo);
		documento.add(new Paragraph(" "));
		PdfPTable tabela = new PdfPTable(3);
		PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
		PdfPCell col2 = new PdfPCell(new Paragraph("Quantidade"));
		PdfPCell col3 = new PdfPCell(new Paragraph("Valor"));
		tabela.addCell(col1);
		tabela.addCell(col2);
		tabela.addCell(col3);

		// Popular a tabela com os dados
		for (Produto produto : venda.getProdutosVendidos()) {
			tabela.addCell(produto.getNome());
			tabela.addCell(String.valueOf(produto.getQuantidade()));
			tabela.addCell(String.valueOf(produto.getValor()));
		}
		documento.add(tabela);
		documento.close();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
