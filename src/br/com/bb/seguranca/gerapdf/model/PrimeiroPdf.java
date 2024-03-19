package br.com.bb.seguranca.gerapdf.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PrimeiroPdf {

	public PrimeiroPdf(String fraseAImprimir) throws DocumentException, FileNotFoundException {

		Document documentPdf = new Document();
		PdfWriter.getInstance(documentPdf, new FileOutputStream("C:\\JAVA\\pdf\\Relatorio.pdf"));

		documentPdf.open();

		Paragraph paragrafoTeste = new Paragraph(fraseAImprimir);

		documentPdf.add(paragrafoTeste);

		documentPdf.close();

	}

}
